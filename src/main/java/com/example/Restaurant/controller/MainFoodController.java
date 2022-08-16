package com.example.Restaurant.controller;

import com.example.Restaurant.entities.Drink;
import com.example.Restaurant.entities.MainFood;
import com.example.Restaurant.service.main.food.MainFoodServiceImpl;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;
import java.util.List;
import java.util.Optional;

@RestController
public class MainFoodController {


    private final MainFoodServiceImpl service;

    public MainFoodController(MainFoodServiceImpl service) {
        this.service = service;
    }

    @PostMapping("/mainfood")
    public void add(@RequestBody MainFood mainFood) {

        service.add(mainFood);

    }

    @DeleteMapping("/mainfood/{id}")
    public void delete(@PathVariable Integer id) {

        service.deleteById(id);

    }

    @PutMapping("/mainfood/{id}")
    public void update(@RequestBody MainFood mainFood, @PathVariable Integer id) {

        service.update(mainFood, id);

    }

    @GetMapping("/mainfood/{pageNo}/{pageSize}")
    public List<MainFood> findAll(@PathVariable  @Min(1) int  pageNo , @PathVariable int pageSize) {

        return service.findall(pageNo-1,pageSize);

    }

    @GetMapping("/mainfood/{id}")
    public Optional<MainFood> findById(@PathVariable int id) {

        return service.findById(id);

    }


}
