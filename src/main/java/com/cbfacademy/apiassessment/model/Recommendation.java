package com.cbfacademy.apiassessment.model;

public class Recommendation {
    private String appliance;
    private int size;
    private int price;

    public Recommendation(String appliance, int size, int price) {
        this.appliance = appliance;
        this.size = size;
        this.price = price;
    }

    public String getAppliance() {
        return appliance;
    }

    public void setAppliance(String appliance) {
        this.appliance = appliance;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

}

