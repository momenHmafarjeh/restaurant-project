package com.example.Restaurant.security.User;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.util.Collection;

@Entity
public class Admin  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;
    @NotEmpty
    private String name ;
    @NotEmpty
    @Min(6)
    private String password ;



    public Admin (String name,String password){
        this.name=name;
        this.password=password;
    }

    public Admin(){}


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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
