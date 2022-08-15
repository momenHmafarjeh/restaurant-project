package com.example.Restaurant.repository;

import com.example.Restaurant.entities.MainFood;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MainFoodRepository extends JpaRepository<MainFood,Integer> {

}
