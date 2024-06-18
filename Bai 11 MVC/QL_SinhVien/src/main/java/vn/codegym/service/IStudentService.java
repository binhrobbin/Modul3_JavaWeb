package vn.codegym.service;

import java.util.List;

public interface IStudentService<E> {
    List<E> findAll();
    void save(E e);
    void update(int id,E e);
    void remove(int id, E e);
    E findById(int id);
}
