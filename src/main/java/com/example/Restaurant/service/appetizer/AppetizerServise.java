package com.example.Restaurant.service.appetizer;

import com.example.Restaurant.entities.Appetizer;

import java.util.List;
import java.util.Optional;

public interface AppetizerServise {

    void add(Appetizer appetizer);

    void deleteById(int id);

    Appetizer update(Appetizer appetizer, int id);

    List<Appetizer> findall(int  pageNo ,int pageSize);

    Optional<Appetizer> findById(int id);

    boolean existsByName(String name);

}
