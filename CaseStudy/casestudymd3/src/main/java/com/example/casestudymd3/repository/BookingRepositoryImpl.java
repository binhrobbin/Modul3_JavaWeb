package com.example.casestudymd3.repository;

import com.example.casestudymd3.model.Booking;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookingRepositoryImpl implements IObjectRepository<Booking>{
    private static final String SELECT_ALL_BOOKING = "select * from tblbooking";

    @Override
    public List<Booking> findAll() {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null; //nạp lệnh SQL
        ResultSet resultSet = null; //nhận kq trả về từ DB
        List<Booking> bookingList = new ArrayList<>();

        if (connection != null) {
            try {
                statement = connection.prepareStatement(SELECT_ALL_BOOKING);
                resultSet = statement.executeQuery();

                Booking booking = null;
                while (resultSet.next()) {
                    int booking_id = resultSet.getInt(1);
                    int user_id = resultSet.getInt("user_id");
                    String booking_day = resultSet.getString("booking_day");
                    booking = new Booking(booking_id, user_id, booking_day);
                    bookingList.add(booking);
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

        return bookingList;
    }

    @Override
    public void save(Booking booking) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null; //nạp lệnh SQL
        if (connection != null) {
            try {
                statement = connection.prepareStatement("insert into tblbooking(id, user_id, booking_day) " +
                        "value (?, ?, ?) ");
                statement.setInt(1, booking.getId());
                statement.setInt(2, booking.getUser_id());
                statement.setString(3, booking.getBooking_day());
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
    public void update(int id, Booking booking) {

    }

    @Override
    public void remove(int id) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null; //nạp lệnh SQL
        if (connection != null) {
            try {
                statement = connection.prepareStatement("delete from tblbooking where id=?");
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
    public Booking findById(int id) {
        return null;
    }
}
