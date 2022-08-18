package com.example.Restaurant.entities;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
//@Table(name = "drink")
public class Drink {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotEmpty
    private String name;

    @Min (value = 1,message = "you cant choose less than 0 ")
    private float qantity;

    public Drink(String name, float qantity) {
        this.name = name;
        this.qantity = qantity;

    }

    public Drink() {

    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
}
