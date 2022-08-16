package com.example.Restaurant.service.user.admin;

import com.example.Restaurant.security.User.Admin;

import java.util.List;
import java.util.Optional;

public interface AdminService {

    void add(Admin admin);

    void deleteById(long id);

    Admin update(Admin admin, long id);

    List<Admin> findall(int  pageNo , int pageSize);

    Optional<Admin> findById(long id);
}
