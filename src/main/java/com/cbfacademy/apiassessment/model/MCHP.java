package com.cbfacademy.apiassessment.model;

public class MCHP extends Appliance{
    private int rooms;
    private int radiators;

    public MCHP(String name, String description, String type, int size, int rooms, int radiators) {
        super(name, description, type, size);
        this.rooms = rooms;
        this.radiators = radiators;
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
}

