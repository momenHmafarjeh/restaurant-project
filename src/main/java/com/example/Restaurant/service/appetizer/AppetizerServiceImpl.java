package com.example.Restaurant.service.appetizer;

import com.example.Restaurant.entities.Appetizer;
import com.example.Restaurant.exception.ResourceNotFoundException;
import com.example.Restaurant.repository.AppetizerRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppetizerServiceImpl implements AppetizerServise {

    private final AppetizerRepository repository;

    public AppetizerServiceImpl(AppetizerRepository repository) {
        this.repository = repository;
    }


    @Override
    public void add(Appetizer appetizer) {
        repository.save(appetizer);
    }

    @Override
    public void deleteById(int id) {

        Optional<Appetizer> tist = repository.findById(id);

        if (tist.isEmpty()) {

            throw new ResourceNotFoundException("id not fond ");

        }

        repository.deleteById(id);

    }

    @Override
    public Appetizer update(Appetizer appetizer, int id) {

        Optional<Appetizer> check = repository.findById(id);
        if (check.isEmpty()) {

            throw new ResourceNotFoundException(" id not exists in database ");
        }

        Appetizer update = repository.findById(id).get();
        update.setName(appetizer.getName());
        update.setQantity(appetizer.getQantity());
        return repository.save(update);

//        if (repository.existsById(id)){
//
//            Appetizer update = repository.findById(id).get();
//            update.setName(appetizer.getName());
//            update.setQantity(appetizer.getQantity());
//            return repository.save(update);
//        }
//        throw new ResourceNotFoundException(" id not exists in database ");
//
    }

    @Override
    public List<Appetizer> findall(int pageNo, int pageSize) {

        Pageable paging = PageRequest.of(pageNo, pageSize);

        return repository.findAll(paging).toList();
    }

    @Override
    public Optional<Appetizer> findById(int id) {

        return repository.findById(id);
    }

    @Override
    public boolean existsByName(String name) {

        return repository.existsByName(name);
    }


}
