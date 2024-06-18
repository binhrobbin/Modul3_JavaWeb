package com.example.casestudymd3.repository;

import com.example.casestudymd3.model.Dog;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DogRepositoryImpl implements IObjectRepository<Dog>{
    private static final String SELECT_ALL_DOG = "select * from tbldog";

    @Override
    public List<Dog> findAll() {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null; //nạp lệnh SQL
        ResultSet resultSet = null; //nhận kq trả về từ DB
        List<Dog> dogList = new ArrayList<>();

        if (connection != null) {
            try {
                statement = connection.prepareStatement(SELECT_ALL_DOG);
                resultSet = statement.executeQuery();

                Dog dog = null;
                while (resultSet.next()) {
                    int dog_id = resultSet.getInt(1);
                    String name = resultSet.getString("name");
                    String type = resultSet.getString("type");
                    String color = resultSet.getString("color");
                    String image = resultSet.getString("image");
                    int price = resultSet.getInt("price");
                    int quantity = resultSet.getInt("quantity");
                    dog = new Dog(dog_id, name, type, color, image, price, quantity);
                    dogList.add(dog);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
                try {
                    resultSet.close();
                    statement.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                DBConnection.close();
            }
        }

        return dogList;
    }

    @Override
    public void save(Dog dog) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null; //nạp lệnh SQL

        if (connection != null) {
            try {
                statement = connection.prepareStatement("insert into tbldog(dog_id, name, type, color, image, price, quantity) " +
                        "value (?, ?, ?, ?, ?, ?, ?) ");
                statement.setInt(1, dog.getId());
                statement.setString(2, dog.getName());
                statement.setString(3, dog.getType());
                statement.setString(4, dog.getColor());
                statement.setString(5, dog.getImage());
                statement.setInt(6, dog.getPrice());
                statement.setInt(7, dog.getQuantity());
                statement.executeUpdate();

            } catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
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
    public void update(int id, Dog dog) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null; //nạp lệnh SQL
        if (connection != null) {
            try {
                statement = connection.prepareStatement("update tbldog set name=?, type=?, color=?, image=?, price=?, quantity=? " +
                        "where dog_id=?");
                statement.setString(1, dog.getName());
                statement.setString(2, dog.getType());
                statement.setString(3, dog.getColor());
                statement.setString(4, dog.getImage());
                statement.setInt(5, dog.getPrice());
                statement.setInt(6, dog.getQuantity());
                statement.setInt(7, id);
                statement.executeUpdate();

            } catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
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
        PreparedStatement statement = null; //nạp lệnh SQL
        if (connection != null) {
            try {
                statement = connection.prepareStatement("delete from tbldog where dog_id=?");
                statement.setInt(1, id);
                statement.executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
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
    public Dog findById(int id) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null; //nạp lệnh SQL
        ResultSet resultSet = null; //nhận kq trả về từ DB
        Dog dog = null;

        if (connection != null) {
            try {
                statement = connection.prepareStatement("select * from tbldog where dog_id=?");
                statement.setInt(1, id);
                resultSet = statement.executeQuery();
                resultSet.next();
                    int dog_id = resultSet.getInt(1);
                    String name = resultSet.getString("name");
                    String type = resultSet.getString("type");
                    String color = resultSet.getString("color");
                    String image = resultSet.getString("image");
                    int price = resultSet.getInt("price");
                    int quantity = resultSet.getInt("quantity");
                    dog = new Dog(dog_id, name, type, color, image, price, quantity);

            } catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
                try {
                    resultSet.close();
                    statement.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                DBConnection.close();
            }
        }

        return dog;
    }
}
