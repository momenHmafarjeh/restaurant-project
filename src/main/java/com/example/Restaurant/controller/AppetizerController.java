package com.example.Restaurant.controller;

import com.example.Restaurant.entities.Appetizer;
import com.example.Restaurant.exception.ResourceNotFoundException;
import com.example.Restaurant.service.appetizer.AppetizerServiceImpl;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.List;
import java.util.Optional;

@RestController
public class AppetizerController {

    private final AppetizerServiceImpl service;

    public AppetizerController(AppetizerServiceImpl service) {
        this.service = service;
    }

    @PostMapping("/admin/appetizer")
    public void add( @RequestBody Appetizer appetizer) {

        service.add(appetizer);
    }

    @DeleteMapping("/admin/appetizer/{id}")
    public void delete(@PathVariable Integer id) {

        service.deleteById(id);
    }

    @PutMapping("/admin/appetizer/{id}")
    public void update(@RequestBody Appetizer appetizer, @PathVariable Integer id) {

        service.update(appetizer, id);

    }


    @GetMapping("/admin/appetizer/{pageNo}/{pageSize}")
    public List<Appetizer> findAll(@PathVariable @Min(1) int pageNo, @PathVariable @Min(1) @Max(4) int pageSize) {

        return service.findall(pageNo - 1, pageSize);

    }

    @GetMapping("/appetizer/{id}")
    public Appetizer findById(@PathVariable int id) {

        Optional<Appetizer> app = service.findById(id);
        if (app.isEmpty()) {
            throw new ResourceNotFoundException("wallah mane lakeh");
        }
        return app.get();

    }

    @GetMapping("/appetizer/exists/{name}")
    boolean existsByName(@PathVariable String name) {

        return service.existsByName(name);
    }

}
