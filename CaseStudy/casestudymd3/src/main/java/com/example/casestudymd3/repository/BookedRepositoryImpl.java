package com.example.casestudymd3.repository;

import com.example.casestudymd3.model.Booked;
import com.example.casestudymd3.model.Dog;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookedRepositoryImpl implements IObjectRepository<Booked>{
    private static final String SELECT_ALL_BOOKED = "select * from tblbooked";

    @Override
    public List<Booked> findAll() {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null; //nạp lệnh SQL
        ResultSet resultSet = null; //nhận kq trả về từ DB
        List<Booked> bookedList = new ArrayList<>();

        if (connection != null) {
            try {
                statement = connection.prepareStatement(SELECT_ALL_BOOKED);
                resultSet = statement.executeQuery();

                Booked booked = null;
                while (resultSet.next()) {
                    int booked_id = resultSet.getInt(1);
                    String booked_day = resultSet.getString("booked_day");
                    int isCheck = resultSet.getInt("isCheck");
                    int booking_id = resultSet.getInt("booking_id");
                    int dog_id = resultSet.getInt("dog_id");
                    booked = new Booked(booked_id, booked_day, isCheck, booking_id, dog_id);
                    bookedList.add(booked);
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

        return bookedList;
    }

    @Override
    public void save(Booked booked) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null; //nạp lệnh SQL
        if (connection != null) {
            try {
                statement = connection.prepareStatement("insert into tblbooked(id, booked_day, ischeck, booking_id, dog_id) " +
                        "value (?, ?, ?, ?, ?) ");
                statement.setInt(1, booked.getId());
                statement.setString(2, booked.getBooked_day());
                statement.setInt(3, booked.getIsCheck());
                statement.setInt(4, booked.getBooking_id());
                statement.setInt(5, booked.getDog_id());
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
    public void update(int id, Booked booked) {

    }

    @Override
    public void remove(int id) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null; //nạp lệnh SQL
        if (connection != null) {
            try {
                statement = connection.prepareStatement("delete from tblbooked where id=?");
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
    public Booked findById(int id) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null; //nạp lệnh SQL
        ResultSet resultSet = null; //nhận kq trả về từ DB
        Booked booked = null;
        if (connection != null) {
            try {
                statement = connection.prepareStatement("select * from tblbooked where id=?");
                statement.setInt(1, id);
                resultSet = statement.executeQuery();
                resultSet.next();
                int booked_id = resultSet.getInt(1);
                String booked_day = resultSet.getString("booked_day");
                int ischeck = resultSet.getInt("ischeck");
                int booking_id = resultSet.getInt("booking_id");
                int dog_id = resultSet.getInt("dog_id");
                booked = new Booked(booked_id, booked_day, ischeck, booking_id, dog_id);

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

        return booked;
    }
}
