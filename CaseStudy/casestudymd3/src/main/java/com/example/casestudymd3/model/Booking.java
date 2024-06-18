package com.example.casestudymd3.model;

public class Booking {
    private int id;
    private int user_id;
    private String booking_day;

    public Booking() {
    }

    public Booking(int user_id, String booking_day) {
        this.user_id = user_id;
        this.booking_day = booking_day;
    }

    public Booking(int id, int user_id, String booking_day) {
        this.id = id;
        this.user_id = user_id;
        this.booking_day = booking_day;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBooking_day() {
        return booking_day;
    }

    public void setBooking_day(String booking_day) {
        this.booking_day = booking_day;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
}
