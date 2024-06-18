package com.example.casestudymd3.service;

import com.example.casestudymd3.model.Booking;
import com.example.casestudymd3.repository.BookingRepositoryImpl;

import java.util.List;

public class BookingServiceImpl implements IObjectService<Booking>{
    private BookingRepositoryImpl repository = new BookingRepositoryImpl();

    @Override
    public List<Booking> findAll() {
        return repository.findAll();
    }

    @Override
    public void save(Booking booking) {
        repository.save(booking);
    }

    @Override
    public void update(int id, Booking booking) {

    }

    @Override
    public void remove(int id) {
        repository.remove(id);
    }

    @Override
    public Booking findById(int id) {
        return repository.findById(id);
    }
}
