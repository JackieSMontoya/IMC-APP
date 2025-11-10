package com.example.model;

public class User {
    private String username;
    private String password;
    private int age;
    private double height;

    // Constructor
    public User(String username, String password, int age, double height) {
        this.username = username;
        this.password = password;
        this.age = age;
        this.height = height;
    }

    // Getters
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getAge() {
        return age;
    }

    public double getHeight() {
        return height;
    }

    // Setters (if needed)
    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setHeight(double height) {
        this.height = height;
    }
}
