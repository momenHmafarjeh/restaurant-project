package com.example.Restaurant.service.main.food;


import com.example.Restaurant.entities.MainFood;
import com.example.Restaurant.repository.MainFoodRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class MainFoodServiceImpl implements MainFoodServise {


    private final MainFoodRepository repository;

    public MainFoodServiceImpl(MainFoodRepository repository) {
        this.repository = repository;
    }


    @Override
    public void add(MainFood mainFood) {

        repository.save(mainFood);

    }

    @Override
    public void deleteById(long id) {
        repository.deleteById(id);
    }

    @Override
    public MainFood update(MainFood mainFood, long id) {

        MainFood update = repository.findById(id).get();

        update.setName(mainFood.getName());
        update.setQantity(mainFood.getQantity());
        return repository.save(update);
    }

    @Override
    public List<MainFood> findall(int  pageNo ,int pageSize) {

        Pageable paging = PageRequest.of(pageNo, pageSize);

        return repository.findAll(paging).toList();
    }

    @Override
    public Optional<MainFood> findById(long id) {

        return repository.findById(id);
    }
}
