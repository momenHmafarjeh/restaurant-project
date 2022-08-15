package com.example.Restaurant.entities;


import javax.persistence.*;

@Entity
@Table(name = "main_food")
public class MainFood {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private float qantity;

    public MainFood(String name, float qantity) {

        this.name = name;
        this.qantity = qantity;

    }

    public MainFood() {

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
