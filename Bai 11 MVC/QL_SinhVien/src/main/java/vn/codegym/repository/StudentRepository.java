package vn.codegym.repository;

import vn.codegym.model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository implements IStudentRepository<Student>{


    public static final String SELECT_ALL_STUDENT = "select * from student";
    public static final String SELECT_FROM_STUDENT_WHERE_ID = "select * from student where id=?";
    public static final String UPDATE_STUDENT_BY_ID = "update student set id=?,name=?,gender=?,point=?,image=? where id=?";
    public static final String DELETE_ROW_STUDENT_WHERE_ID = "delete from student where id=?";

    @Override
    public List<Student> findAll() {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null; // nạp lệnh SQL
        ResultSet resultSet = null ; // nhận kq trả về (ôm cả bảng về)
        List<Student> studentList = new ArrayList<>();
        if (connection != null){
            try {
                statement = connection.prepareStatement(SELECT_ALL_STUDENT);
                resultSet = statement.executeQuery();

                Student student = null;
                while (resultSet.next()){
                    int id = resultSet.getInt(1);
                    String name = resultSet.getString("name");
                    int gender = resultSet.getInt("gender");
                    int point = resultSet.getInt("point");
                    String image = resultSet.getString("image");
                    student = new Student(id,name,gender,point,image);
                    studentList.add(student);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }finally {
                try {
                    resultSet.close();
                    statement.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                DBConnection.close();
            }
        }
        return studentList;
    }

    @Override
    public void save(Student student) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null; // nạp lệnh SQL
        if (connection != null){
            try {
                statement = connection.prepareStatement("insert into student(id,name,gender,point,image) values " +
                        "(?, ?, ?, ?, ?)");
                statement.setInt(1,student.getId());
                statement.setString (2,student.getName());
                statement.setInt(3,student.getGender());
                statement.setInt(4,student.getPoint());
                statement.setString(5,student.getImage());
                statement.executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }finally {
                try {
                    statement.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                DBConnection.close();
            }
        }
    }

    @Override
    public void update(int id, Student student) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        if (connection != null){
            try {
                statement = connection.prepareStatement(UPDATE_STUDENT_BY_ID);
                statement.setInt(1,student.getId());
                statement.setString(2,student.getName());
                statement.setInt(3,student.getGender());
                statement.setInt(4,student.getPoint());
                statement.setString(5,student.getImage());
                statement.setInt(6,id);
                statement.executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }finally {
                try {
                    statement.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                DBConnection.close();
            }
        }
    }

    @Override
    public void remove(int id, Student student) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        if (connection != null){
            try {
                statement = connection.prepareStatement(DELETE_ROW_STUDENT_WHERE_ID);
                statement.setInt(1,id);
                statement.execute();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }finally {
                try {
                    statement.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                DBConnection.close();
            }
        }
    }

    @Override
    public Student findById(int id) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Student student = null;
        if (connection != null){
            try {
                statement = connection.prepareStatement(SELECT_FROM_STUDENT_WHERE_ID);
            statement.setInt(1,id);
            resultSet = statement.executeQuery();
                resultSet.next();
            String name = resultSet.getString("name");
            int gender = resultSet.getInt("gender");
            int point = resultSet.getInt("point");
            String image = resultSet.getString("image");
            student = new Student(id,name,gender,point,image);
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                try {
                    resultSet.close();
                    statement.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                DBConnection.close();
            }
        }
        return student;
    }
}
