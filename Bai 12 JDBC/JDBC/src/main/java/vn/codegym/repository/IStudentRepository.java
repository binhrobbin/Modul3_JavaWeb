package vn.codegym.repository;

import vn.codegym.model.Student;

import java.util.List;

public interface IStudentRepository {
    //Connect DB
    //Query data

    List<Student> finAll();

    void save(Student student);
}
