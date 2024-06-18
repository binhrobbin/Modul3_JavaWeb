package vn.codegym.repository;

import vn.codegym.model.User;

import java.sql.SQLException;
import java.util.List;

public interface IUserDAO {
    public void insertUser (User user) throws SQLException;
    public User selectUser(int id);
    public List<User> selectAllUsers();
    boolean deleteUser (int id) throws SQLException;
    boolean updateUser (User user) throws SQLException;
}
