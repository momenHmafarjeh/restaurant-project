package com.example.Restaurant.service.drink;

import com.example.Restaurant.entities.Appetizer;
import com.example.Restaurant.entities.Drink;

import java.util.List;
import java.util.Optional;

public interface DrinkService {

    void add(Drink drink);

    void deleteById(long id);

    Drink update(Drink drink, long id);

    List<Drink> findall(int  pageNo ,int pageSize);

    Optional<Drink> findById(long id);
}
