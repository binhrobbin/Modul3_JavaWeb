package vn.codegym.repository;

import vn.codegym.model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentRepositoryImpl implements IStudentRepository{
    //ket noi DB
    private static List<Student> studentList;

    static {
        studentList = new ArrayList<>();
        studentList.add(new Student(1, "Nguyen Van A", 1, 100,"avatar.png"));
        studentList.add(new Student(2, "Nguyen Van B", 0, 10,"avatar_1.jpg"));
        studentList.add(new Student(3, "Nguyen Van C", 2, 50,"avatar_2.png"));
        studentList.add(new Student(4, "Nguyen Van D", 1, 80,"avatar_3.jpg"));
    }

    @Override
    public List<Student> finAll() {
        return studentList;
    }

    @Override
    public void save(Student student) {
        studentList.add(0, student);
    }
}
