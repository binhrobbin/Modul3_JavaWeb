package vn.codegym.model;

public class Student {
    private int id;
    private String name;
    private int gender;
    private int point;
    private String image;

    public Student() {
    }

    public Student(int id, String name, int gender, int point, String image) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.point = point;
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

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
