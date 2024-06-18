package vn.codegym.repository;

import vn.codegym.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements IUserDAO{

    public static final String INSERT_USERS_SQL = "INSERT INTO users (name, email, country) VALUES (?, ?, ?);";
    public static final String SELECT_USER_BY_ID = "select id,name,email,country from users where id =?";
    public static final String SELECT_ALL_USERS = "select * from users";
    public static final String DELETE_FROM_USERS_WHERE_ID = "delete from users where id=?";
    public static final String UPDATE_USERS_WHERE_ID = "update users set name=?,email=?,country=? where id=?";

    @Override
    public void insertUser(User user) throws SQLException {
        System.out.println(INSERT_USERS_SQL);
        try (Connection connection = DBConnection.getConnection(); PreparedStatement statement = connection.prepareStatement(INSERT_USERS_SQL)) {
            statement.setString(1, user.getName());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getCountry());
            System.out.println(statement);
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public User selectUser(int id) {
        User user = null;
        try (Connection connection = DBConnection.getConnection();PreparedStatement statement = connection.prepareStatement(SELECT_USER_BY_ID);){
            statement.setInt(1,id);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String country = resultSet.getString("country");
                user = new User(id,name,email,country);
            resultSet.close();
        } catch (SQLException e) {
            printSQLException(e);
        }
        return user;
    }

    @Override
    public List<User> selectAllUsers() {
        List<User> userList = new ArrayList<>();
        try (Connection connection = DBConnection.getConnection();PreparedStatement statement = connection.prepareStatement(SELECT_ALL_USERS);) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String country = resultSet.getString("country");
                userList.add(new User(id,name,email,country));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return userList;
    }

    @Override
    public boolean deleteUser(int id) {
        boolean rowDeleted;
        try(Connection connection = DBConnection.getConnection();PreparedStatement statement = connection.prepareStatement(DELETE_FROM_USERS_WHERE_ID);) {
            statement.setInt(1,id);
            rowDeleted = statement.executeUpdate() >0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rowDeleted;
    }

    @Override
    public boolean updateUser(User user) {
        boolean rowUpdated =false;
        try(Connection connection = DBConnection.getConnection();PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_WHERE_ID);) {
            statement.setString(1,user.getName());
            statement.setString(2,user.getEmail());
            statement.setString(3,user.getCountry());
            statement.setInt(4,user.getId());
            rowUpdated = statement.executeUpdate()>0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rowUpdated;
    }
    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
