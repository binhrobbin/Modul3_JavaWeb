package com.example.casestudymd3.service;

import com.example.casestudymd3.model.Bill;
import com.example.casestudymd3.repository.BillRepositoryImpl;
import com.example.casestudymd3.repository.IObjectRepository;

import java.util.List;

public class BillServiceImpl implements IObjectService<Bill>{
    private BillRepositoryImpl repository = new BillRepositoryImpl();

    @Override
    public List<Bill> findAll() {
        return repository.findAll();
    }

    @Override
    public void save(Bill bill) {
        repository.save(bill);
    }

    @Override
    public void update(int id, Bill bill) {

    }

    @Override
    public void remove(int id) {

    }

    @Override
    public Bill findById(int id) {
        return repository.findById(id);
    }
}
