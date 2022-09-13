package com.example.Restaurant.service.user.admin;

import com.example.Restaurant.security.User.Admin;
import com.example.Restaurant.security.User.repository.AdminRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService {


    private final AdminRepository repository;

    public AdminServiceImpl(AdminRepository adminRepository) {
        this.repository = adminRepository;
    }

    @Override
    public void add(Admin admin) {
        repository.save(admin);
    }


    @Override
    public void deleteById(long id) {
        repository.deleteById(id);
    }


    @Override
    public Admin update(Admin admin, long id) {

        Admin update = repository.findById(id).get();
        update.setName(admin.getName());
        update.setPassword(admin.getPassword());
        return repository.save(update);
    }

    @Override
    @Cacheable(value = "admin", key = "#p0" )
    public List<Admin> findall(int  pageNo , int pageSize) {
        Pageable paging = PageRequest.of(pageNo, pageSize);

        return repository.findAll(paging).toList();
    }

    @Override
    public Optional<Admin> findById(long id) {

        return repository.findById(id);
    }
}
