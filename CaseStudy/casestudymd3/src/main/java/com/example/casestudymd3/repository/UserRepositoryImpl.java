package com.example.casestudymd3.repository;

import com.example.casestudymd3.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImpl implements IObjectRepository<User>{

    public static final String SELECT_ALL_TBLUSER = "select * from tbluser";
    public static final String SELECT_FROM_TBLUSER_WHERE_ID = "select * from tbluser where id=?";
    public static final String UPDATE_TBLUSER_BY_ID = "update tbluser set name=?,username=?,password=?,money=?,role=?,image=? where id=?";
    public static final String DELETE_ROW_TBLUSER_WHERE_ID = "delete from tbluser where id=?";
    public static final String INSERT_TBLUSER_BY_ID = "insert into tbluser(name,username,password,money,role,image) values " +
            "( ?, ?, ?, ?, ?, ?)";

    @Override
    public List<User> findAll() {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null; // nạp lệnh SQL
        ResultSet resultSet = null ; // nhận kq trả về (ôm cả bảng về)
        List<User> userList = new ArrayList<>();
        if (connection != null){
            try {
                statement = connection.prepareStatement(SELECT_ALL_TBLUSER);
                resultSet = statement.executeQuery();

                User user = null;
                while (resultSet.next()){
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    String username = resultSet.getString("username");
                    String password = resultSet.getString("password");
                    int money = resultSet.getInt("money");
                    String role = resultSet.getString("role");
                    String image = resultSet.getString("image");
                    user = new User(id,name,username,password,money,role,image);
                    userList.add(user);
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
        return userList;
    }

    @Override
    public void save(User user) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null; // nạp lệnh SQL
        if (connection != null){
            try {
                statement = connection.prepareStatement(INSERT_TBLUSER_BY_ID);
                statement.setString (1,user.getName());
                statement.setString (2,user.getUsername());
                statement.setString (3,user.getPassword());
                statement.setInt(4,user.getMoney());
                statement.setString(5,user.getRole());
                statement.setString(6,user.getImage());
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
    public void update(int id, User user) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        if (connection != null){
            try {
                statement = connection.prepareStatement(UPDATE_TBLUSER_BY_ID);
                statement.setString (1,user.getName());
                statement.setString (2,user.getUsername());
                statement.setString (3,user.getPassword());
                statement.setInt(4,user.getMoney());
                statement.setString(5,user.getRole());
                statement.setString(6,user.getImage());
                statement.setInt(7,id);
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
    public void remove(int id) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        if (connection != null){
            try {
                statement = connection.prepareStatement(DELETE_ROW_TBLUSER_WHERE_ID);
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
    public User findById(int id) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        User user = null;
        if (connection != null){
            try {
                statement = connection.prepareStatement(SELECT_FROM_TBLUSER_WHERE_ID);
                statement.setInt(1,id);
                resultSet = statement.executeQuery();
                resultSet.next();
                String name = resultSet.getString("name");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                int money = resultSet.getInt("money");
                String role = resultSet.getString("role");
                String image = resultSet.getString("image");
                user = new User(id,name,username,password,money,role,image);
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
        return user;
    }
}
