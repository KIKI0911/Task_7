package com.kiki.user.entity;

import java.util.Objects;

public class User {
    private Integer id;
    private String name;
    private String email;
    private Integer addressId;
    private Integer age;

    public User(Integer id, String name, String email, Integer addressId, Integer age) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.addressId = addressId;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public Integer getAge() {
        return age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(name, user.name) && Objects.equals(email, user.email) && Objects.equals(addressId, user.addressId) && Objects.equals(age, user.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, addressId, age);
    }
}
