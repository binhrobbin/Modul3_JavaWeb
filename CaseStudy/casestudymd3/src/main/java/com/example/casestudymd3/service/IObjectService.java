package com.example.casestudymd3.service;

import java.util.List;

public interface IObjectService<E> {
    List<E> findAll();

    void save(E e);
    void update(int id,E e);
    void remove(int id);
    E findById(int id);
}
