package com.example.Restaurant.security;

import com.example.Restaurant.security.User.Admin;
import com.example.Restaurant.security.User.repository.AdminRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserService implements UserDetailsService {

final AdminRepository adminRepository;

    public UserService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @Bean
    private PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

     Admin user1 = (Admin) adminRepository.findByName(username);

        return new User(user1.getName(),passwordEncoder().encode(user1.getPassword()),Collections.emptyList());

    }
}
