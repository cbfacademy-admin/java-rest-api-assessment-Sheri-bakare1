package com.cbfacademy.apiassessment.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Appliance {
    private int id;
    private String name;
    private String description;
    private String type;
    private int size;

    private int rooms;

    private int radiators;

    private int price;


    // Constructor

    public Appliance(String name, String description, String type, int size) {
        this.name = name;
        this.description = description;
        this.type = type;
        this.size = size;

    }



    @Override
    public boolean equals(Object obj) {
        Appliance app = (Appliance) obj;
        return app.getId() == this.id;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public int getRooms() {
        return rooms;
    }

    public void setRooms(int rooms) {
        this.rooms = rooms;
    }

    public int getRadiators() {
        return radiators;
    }

    public void setRadiators(int radiators) {
        this.radiators = radiators;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}



