package com.example.Restaurant.controller;

import com.example.Restaurant.entities.MainFood;
import com.example.Restaurant.rabbitmq.MainFoodStatus;
import com.example.Restaurant.rabbitmq.RabbitMq;
import com.example.Restaurant.service.main.food.MainFoodServiceImpl;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;
import java.util.Optional;

@RestController
public class MainFoodController {


    private final MainFoodServiceImpl service;
    private final RabbitTemplate rabbitTemplate;

    public MainFoodController(MainFoodServiceImpl service, RabbitTemplate rabbitTemplate) {
        this.service = service;
        this.rabbitTemplate = rabbitTemplate;
    }

    @PostMapping("/admin/mainfood")
    public void add(@Valid @RequestBody MainFood mainFood) {
        service.add(mainFood);

    }

    @DeleteMapping("/admin/mainfood/{id}")
    public void delete(@PathVariable Integer id) {

        service.deleteById(id);

    }

    @PutMapping("/admin/mainfood/{id}")
    public void update(@RequestBody MainFood mainFood, @PathVariable Integer id) {

        service.update(mainFood, id);

    }

    @Cacheable(value = "food", key = "#p1")
    @GetMapping("/admin/mainfood/{pageNo}/{pageSize}")
    public List<MainFood> findAll(@PathVariable @Min(1) int pageNo, @PathVariable int pageSize) {

        return service.findall(pageNo - 1, pageSize);

    }

    @GetMapping("/mainfood/{id}")
    public Optional<MainFood> findById(@PathVariable int id) {


        MainFood mainFood = service.findById(id).get();
        rabbitTemplate.convertAndSend(RabbitMq.exchange, RabbitMq.rouingKey1, mainFood);
        return service.findById(id);

    }

}
