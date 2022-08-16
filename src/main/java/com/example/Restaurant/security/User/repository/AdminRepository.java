package com.example.Restaurant.security.User.repository;

import com.example.Restaurant.security.User.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin,Long> {
    @Query("select a from Admin a where a.name = ?1")
    Admin findByName(String name);


}
