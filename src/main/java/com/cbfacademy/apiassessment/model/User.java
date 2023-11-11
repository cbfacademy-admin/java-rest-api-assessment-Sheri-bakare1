package com.cbfacademy.apiassessment.model;
// this is a simple user profile

public class User {

    private int id;
    private String name;
    private int age;
    private String email;

    public User( int id, String name, int age, String email) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public int getID() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName() {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge() {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail() {
        this.email = email;
    }
}
