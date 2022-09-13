package com.example.Restaurant.rabbitmq;

import com.example.Restaurant.entities.MainFood;

import java.io.Serializable;
import java.util.Optional;

public class MainFoodStatus implements Serializable {
    Optional<MainFood> mainFood;
    String status;
    String message;

    public MainFoodStatus( Optional<MainFood> mainFood ) {
        this.mainFood = mainFood;

    }


    public MainFoodStatus(){

    }

}
