package com.cbfacademy.apiassessment.model;

public class HeatPump extends Appliance {
        private String volume;
        private int size;
        private int rooms;
        private int radiators;

        public HeatPump(String name, String description, String type, String volume, int size, int rooms, int radiators, double price) {
            super();
            this.volume = volume;
            this.size = size;
            this.rooms = rooms;
            this.radiators = radiators;
        }

        public String getVolume() {
            return volume;
        }

        public void setVolume(String volume) {
            this.volume = volume;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
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
}
