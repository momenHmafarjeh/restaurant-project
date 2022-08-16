package com.example.Restaurant.controller;

import com.example.Restaurant.entities.Drink;
import com.example.Restaurant.service.drink.DrinkService;
import com.example.Restaurant.service.drink.DrinkServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class DrinkController {


    private final DrinkService service;

    public DrinkController(DrinkServiceImpl service) {
        this.service = service;
    }

    @PostMapping("/drink")
    public void add(@RequestBody Drink drink) {

        service.add(drink);

    }

    @DeleteMapping("/drink/{id}")
    public void delete(@PathVariable Integer id) {

        service.deleteById(id);

    }

    @PutMapping("/drink/{id}")
    public void update(@RequestBody Drink drink, @PathVariable Integer id) {

        service.update(drink, id);

    }

    @GetMapping("/drink/{pageNo}/{pageSize}")
    public List<Drink> findAll(@PathVariable int  pageNo ,@PathVariable int pageSize) {

        return service.findall(pageNo-1,pageSize);

    }

    @GetMapping("/drink/{id}")
    public Optional<Drink> findById(@PathVariable int id) {

        return service.findById(id);

    }

}
