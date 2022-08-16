package com.example.Restaurant.service.drink;

import com.example.Restaurant.entities.Appetizer;
import com.example.Restaurant.entities.Drink;
import com.example.Restaurant.repository.DrinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DrinkServiceImpl implements DrinkService {


    private final DrinkRepository repository;

    public DrinkServiceImpl(DrinkRepository drinkRepository) {
        this.repository = drinkRepository;
    }

    @Override
    public void add(Drink drink) {
        repository.save(drink);
    }

    @Override
    public void deleteById(long id) {
        repository.deleteById(id);
    }

    @Override
    public Drink update(Drink drink,long id) {

        Drink update = repository.findById(id).get();
        update.setName(drink.getName());
        update.setQantity(drink.getQantity());
        return repository.save(update);
    }

    @Override
    public List<Drink> findall(int  pageNo ,int pageSize) {
        Pageable paging = PageRequest.of(pageNo, pageSize);

        return repository.findAll(paging).toList();
    }


    @Override
    public Optional<Drink> findById(long id) {

        return repository.findById(id);
    }
}
