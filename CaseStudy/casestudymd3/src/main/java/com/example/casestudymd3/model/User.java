package com.example.casestudymd3.model;

public class User {
    private int id;
    private String name;
    private String username;
    private String password;
    private int money = 500;
    private String role = "customer";
    private String image;

    public User(int id, String name, String username, String password, int money, String role, String image) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
        this.money = money;
        this.role = role;
        this.image = image;
    }

    public User() {
    }

    public User(int id,String name, String username, String password, String image) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
        this.image = image;
    }
    public User(String name, String username, String password, String image) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}


