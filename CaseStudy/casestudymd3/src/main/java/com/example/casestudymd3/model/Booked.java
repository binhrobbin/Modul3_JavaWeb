package com.example.casestudymd3.model;

public class Booked {
    private int id;
    private String booked_day;
    private int isCheck = 0;
    private int booking_id;
    private int dog_id;

    public Booked() {
    }

    public Booked(String booked_day, int booking_id, int dog_id) {
        this.booked_day = booked_day;
        this.booking_id = booking_id;
        this.dog_id = dog_id;
    }

    public Booked(int id, String booked_day, int isCheck, int booking_id, int dog_id) {
        this.id = id;
        this.booked_day = booked_day;
        this.isCheck = isCheck;
        this.booking_id = booking_id;
        this.dog_id = dog_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBooked_day() {
        return booked_day;
    }

    public void setBooked_day(String booked_day) {
        this.booked_day = booked_day;
    }

    public int getIsCheck() {
        return isCheck;
    }

    public void setIsCheck(int isCheck) {
        this.isCheck = isCheck;
    }

    public int getBooking_id() {
        return booking_id;
    }

    public void setBooking_id(int booking_id) {
        this.booking_id = booking_id;
    }

    public int getDog_id() {
        return dog_id;
    }

    public void setDog_id(int dog_id) {
        this.dog_id = dog_id;
    }
}
