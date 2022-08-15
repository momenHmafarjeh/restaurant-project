package com.example.Restaurant.service.main.food;

import com.example.Restaurant.entities.Drink;
import com.example.Restaurant.entities.MainFood;

import java.util.List;
import java.util.Optional;

public interface MainFoodServise {

    void add(MainFood mainFood);

    void deleteById(int id);

    MainFood update(MainFood mainFood, int id);

    List<MainFood> findall(int  pageNo ,int pageSize);

    Optional<MainFood> findById(int id);

}
