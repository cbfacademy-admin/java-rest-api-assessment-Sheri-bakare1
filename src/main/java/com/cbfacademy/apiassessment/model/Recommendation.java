package com.cbfacademy.apiassessment.model;

public class Recommendation {
    private Appliance appliance;
    private int price;

    public Recommendation(Appliance appliance, int price) {
        this.appliance = appliance;
        this.price = price;
    }

    public Appliance getAppliance() {
        return appliance;
    }

    public void setAppliance(Appliance appliance) {
        this.appliance = appliance;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

}

