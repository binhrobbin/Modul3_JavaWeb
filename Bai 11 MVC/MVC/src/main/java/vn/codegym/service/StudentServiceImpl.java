package vn.codegym.service;

import vn.codegym.model.Student;
import vn.codegym.repository.IStudentRepository;
import vn.codegym.repository.StudentRepositoryImpl;

import java.util.List;

public class StudentServiceImpl implements IStudentService{
    private IStudentRepository repository = new StudentRepositoryImpl();

    @Override
    public List<Student> finAll() {
        return repository.finAll();
    }

    @Override
    public void save(Student student) {
        repository.save(student);
    }
}
