package com.cbfacademy.apiassessment.model;

///This is the logic for selecting the appliance based on the number of rooms and the presence of radiatiors
public class ApplianceSelection extends Appliance {


    public ApplianceSelection(String name, String description, String type, int volume, int size, int price) {
        super(name, description, type, volume, size, price);
    }

    public ApplianceSelection() {
        super();
    }


    public Recommendation createHeatPumpRecommendation(Integer numberOfRooms) {
        if (numberOfRooms == null) {
            throw new RuntimeException("Number of rooms cannot be null");
        }

        int ashpSize;
        int price;

        switch (numberOfRooms) {
            case 2:
                ashpSize = 5;
                price = 1700;
                break;
            case 3:
                ashpSize = 9;
                price = 2400;
                break;
            case 4:
                ashpSize = 16;
                price = 3100;
                break;
            default:
                throw new RuntimeException("Invalid number of rooms for heat pump sizing");
        }

        return new Recommendation("Heat Pump", ashpSize, price);
    }

    // This method for sizing a boiler and getting its price
    public Recommendation createBoilerRecommendation(Integer numberOfRooms, Integer numberOfRadiators) {
        if (numberOfRooms == null || numberOfRadiators == null) {
            throw new RuntimeException("Number of rooms and number of radiators cannot be null");
        }

        int boilerSize;
        int price;

        if (numberOfRooms <= 2 && numberOfRadiators <= 10) {
            boilerSize = 24; // 24-27 kW
            price = 750;
        } else if (numberOfRooms == 3 && numberOfRadiators > 10) {
            boilerSize = 28; // 28-34 kW
            price = 1150;
        } else if (numberOfRooms >= 4 && numberOfRadiators > 20) {
            boilerSize = 35; // 35-43 kW
            price = 1550;
        } else {
            throw new RuntimeException("Invalid parameters for boiler sizing");
        }

        return new Recommendation("Boiler", boilerSize, price);
    }

    // Method for sizing an MCHP and getting its price
    public Recommendation createMchpRecommendation(Integer numberOfRooms) {
        if (numberOfRooms == null) {
            throw new RuntimeException("Please review the number of rooms entered.Number of rooms cannot be null");
        }

        int mchpSize;
        int price;

        switch (numberOfRooms) {
            case 2:
                mchpSize = 25;
                price = 900;
                break;
            case 3:
                mchpSize = 45;
                price = 1300;
                break;
            case 4:
                mchpSize = 60;
                price = 1700;
                break;
            default:
                throw new RuntimeException("Please review the number of rooms for MCHP sizing. Please enter a valid number of rooms.");
        }

        return new Recommendation("MCHP", mchpSize, price);
    }
}
