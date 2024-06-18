package com.example.casestudymd3.repository;

import com.example.casestudymd3.model.Dog;

import java.util.List;

public interface IObjectRepository<E> {
    List<E> findAll();
    void save(E e);
    void update(int id,E e);
    void remove(int id);
    E findById(int id);
}
