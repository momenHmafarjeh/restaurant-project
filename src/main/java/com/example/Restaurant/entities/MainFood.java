package com.example.Restaurant.entities;


import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Optional;

@Entity
//@Table(name = "main_food")
public class MainFood implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotEmpty(message = "cant add name empty")
    private String name;

   @Min(value = 1 ,  message = "you cant choose less than 0 ")
    private float qantity;

    public MainFood(String name, float qantity) {

        this.name = name;
        this.qantity = qantity;

    }
    public MainFood(){}

    public MainFood(Optional<MainFood> byId, String process, String order_placed_successfully) {

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getQantity() {
        return qantity;
    }

    public void setQantity(float qantity) {
        this.qantity = qantity;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
