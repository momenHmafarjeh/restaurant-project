package com.example.Restaurant.entities;

import javax.persistence.*;

@Entity
@Table(name = "drink")
public class Drink {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private float qantity;

    public Drink(String name, float qantity) {
        this.name = name;
        this.qantity = qantity;

    }

    public Drink() {

    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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