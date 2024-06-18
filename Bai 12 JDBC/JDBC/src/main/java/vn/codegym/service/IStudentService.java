package vn.codegym.service;

import vn.codegym.model.Student;

import java.util.List;

public interface IStudentService {
    //CRUD - sort - search
    //Validate

    List<Student> finAll();

    void save(Student student);
}
