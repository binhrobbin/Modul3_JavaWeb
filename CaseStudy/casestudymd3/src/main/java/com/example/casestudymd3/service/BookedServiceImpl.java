package com.example.casestudymd3.service;

import com.example.casestudymd3.model.Booked;
import com.example.casestudymd3.repository.BookedRepositoryImpl;
import com.example.casestudymd3.repository.IObjectRepository;

import java.util.List;

public class BookedServiceImpl implements IObjectService<Booked>{
    private BookedRepositoryImpl repository = new BookedRepositoryImpl();
    @Override
    public List<Booked> findAll() {
        return repository.findAll();
    }

    @Override
    public void save(Booked booked) {
        repository.save(booked);
    }

    @Override
    public void update(int id, Booked booked) {

    }

    @Override
    public void remove(int id) {
        repository.remove(id);
    }

    @Override
    public Booked findById(int id) {
        return repository.findById(id);
    }
}
