package com.cbfacademy.apiassessment.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Appliance {
    private String name;
    @JsonProperty("desc")
    private String description;
    private int volume;
    private int size;


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

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
