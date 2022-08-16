package com.example.Restaurant.controller;

import com.example.Restaurant.entities.Drink;
import com.example.Restaurant.security.User.Admin;
import com.example.Restaurant.service.drink.DrinkService;
import com.example.Restaurant.service.drink.DrinkServiceImpl;
import com.example.Restaurant.service.user.admin.AdminService;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping("/admin/{id}")
    public void update(@RequestBody Admin admin, @PathVariable Integer id) {

        service.update(admin, id);

    }

    @GetMapping("/admin/{pageNo}/{pageSize}")
    public List<Admin> findAll(@PathVariable int  pageNo  ,@PathVariable int pageSize) {

        return service.findall(pageNo-1,pageSize);

    }

    @GetMapping("/admin/{id}")
    public Optional<Admin> findById(@PathVariable int id) {

        return service.findById(id);

    }

}
