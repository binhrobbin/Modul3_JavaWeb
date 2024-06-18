package com.example.casestudymd3.model;

public class Bill {
    private int id;
    private int user_id;
    private int booking_id;
    private String payment_date;

    public Bill() {
    }

    public Bill(int id, int user_id, int booking_id, String payment_date) {
        this.id = id;
        this.user_id = user_id;
        this.booking_id = booking_id;
        this.payment_date = payment_date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getBooking_id() {
        return booking_id;
    }

    public void setBooking_id(int booking_id) {
        this.booking_id = booking_id;
    }

    public String getPayment_date() {
        return payment_date;
    }

    public void setPayment_date(String payment_date) {
        this.payment_date = payment_date;
    }
}
