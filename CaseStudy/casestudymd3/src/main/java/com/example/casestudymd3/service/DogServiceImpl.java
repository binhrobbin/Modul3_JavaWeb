package com.example.casestudymd3.service;

import com.example.casestudymd3.model.Dog;
import com.example.casestudymd3.repository.BillRepositoryImpl;
import com.example.casestudymd3.repository.DogRepositoryImpl;
import com.example.casestudymd3.repository.IObjectRepository;

import java.util.List;

public class DogServiceImpl implements IObjectService<Dog>{
    private DogRepositoryImpl repository = new DogRepositoryImpl();

    @Override
    public List<Dog> findAll() {
        return repository.findAll();
    }

    @Override
    public void save(Dog dog) {
        repository.save(dog);
    }

    @Override
    public void update(int id, Dog dog) {
        repository.update(id, dog);
    }

    @Override
    public void remove(int id) {
        repository.remove(id);
    }

    @Override
    public Dog findById(int id) {
        return repository.findById(id);
    }
}
