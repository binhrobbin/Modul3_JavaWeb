package com.example.casestudymd3.model;

public class Dog {
    private int dog_id;
    private String name;
    private String type;
    private String color;
    private String image;
    private int price;
    private int quantity;

    public Dog() {
    }

    public Dog(String name, int price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public Dog(int dog_id, String name, String type, String color, String image, int price, int quantity) {
        this.dog_id = dog_id;
        this.name = name;
        this.type = type;
        this.color = color;
        this.image = image;
        this.price = price;
        this.quantity = quantity;
    }

    public int getId() {
        return dog_id;
    }

    public void setId(int id) {
        this.dog_id = dog_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
