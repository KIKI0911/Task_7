package com.kiki.user;

public class User {
    private int id;
    private String name;
    private String email;
    private int addressId;
    private int age;

    public User(int id, String name, String email, int addressId, int age) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.addressId = addressId;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getAddressId() {
        return addressId;
    }

    public int getAge() {
        return age;
    }
}
