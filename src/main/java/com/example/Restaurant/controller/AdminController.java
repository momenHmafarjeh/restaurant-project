package com.example.Restaurant.controller;


import com.example.Restaurant.security.User.Admin;
import com.example.Restaurant.service.user.admin.AdminService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class AdminController {

    private final AdminService service;

    public AdminController(AdminService service) {
        this.service = service;
    }

    @PostMapping("/admin")
    public void add(@RequestBody Admin admin) {

        service.add(admin);

    }

    @DeleteMapping("/admin/{id}")
    public void delete(@PathVariable Integer id) {

        service.deleteById(id);

    }

    //    @CachePut(value = "users", key = "#p0")
    @PutMapping("/admin/{id}")
    public void update(@RequestBody Admin admin, @PathVariable Integer id) {

        service.update(admin, id);

    }

//    @Cacheable(value = "admin", key = "#p0")
    @GetMapping("/admin/{pageNo}/{pageSize}")
    public List<Admin> findAll(@PathVariable int pageNo, @PathVariable int pageSize) {

        return service.findall(pageNo - 1, pageSize);

    }

    @GetMapping("/admin/{id}")
    public Optional<Admin> findById(@PathVariable int id) {

        return service.findById(id);

    }

}
