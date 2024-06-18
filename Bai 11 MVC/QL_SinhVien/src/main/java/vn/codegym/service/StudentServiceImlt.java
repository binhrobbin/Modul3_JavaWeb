package vn.codegym.service;

import vn.codegym.model.Student;
import vn.codegym.repository.StudentRepository;

import java.util.List;

public class StudentServiceImlt implements IStudentService<Student> {
    private StudentRepository repository = new StudentRepository();

    @Override
    public List<Student> findAll() {
        return repository.findAll();
    }

    @Override
    public void save(Student student) {
        repository.save(student);
    }

    @Override
    public void update(int id, Student student) {
        repository.update(id,student);
    }

    @Override
    public void remove(int id, Student student) {
        repository.remove(id,student);
    }

    @Override
    public Student findById(int id) {
//       Student student = repository.findById(id);
       return repository.findById(id);
    }
}
