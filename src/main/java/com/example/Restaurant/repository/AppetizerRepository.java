package com.example.Restaurant.repository;

import com.example.Restaurant.entities.Appetizer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AppetizerRepository extends JpaRepository <Appetizer, Long>{

    @Query("select (count(a) > 0) from Appetizer a where a.name = ?1")
    boolean existsByName(String name);


}
