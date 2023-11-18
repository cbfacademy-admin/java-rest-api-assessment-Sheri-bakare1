package com.cbfacademy.apiassessment.model;
// this is a simple user profile

import com.fasterxml.jackson.annotation.JsonTypeId;

import java.time.LocalDate;

@Entity
@Table
public class User {
     @JsonTypeId
     @
    private Long id;
    private String name;

    private LocalDate dob;
    private Integer age;
    private String email;

    public User( Long id,
                 String name,
                 Integer age,
                 LocalDate dob,
                 String email) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.dob = dob;
    }

    public Long getID() {
        return id;
    }

    public void setId(Long id) {
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
    public LocalDate getDob() {
        return dob;
    }

    public void setDob() {
        this.dob = dob;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail() {
        this.email = email;
    }
}
