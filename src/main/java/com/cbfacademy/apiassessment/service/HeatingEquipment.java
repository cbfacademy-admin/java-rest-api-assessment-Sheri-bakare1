package com.cbfacademy.apiassessment.service;
//My logic for selcting thr right appliace
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class HeatingEquipment extends Appliance {

    // This class is meant to provide a list of equipments to the user so that they can see the size and cost of each equipment
    public HeatingEquipment() {
        super();
    }

    // this is my method for sizing a heat pump and getting its price
    public String sizeHeatPump(Integer numberOfRooms) {
        try {
            if (numberOfRooms == null) {
                throw new RuntimeException("Number of rooms cannot be null");
            }

            int ashpSize;
            int price;

            switch (numberOfRooms) {
                case 2:
                    ashpSize = 5; // 5 kW for 2 rooms
                    price = 500; // Example price
                    break;
                case 3:
                    ashpSize = 9; // 9 kW for 3 rooms
                    price = 900; // Example price
                    break;
                case 4:
                    ashpSize = 16; // 16 kW for 4 rooms
                    price = 1600; // Example price
                    break;
                default:
                    return "Custom ASHP size required based on property specifics. Pricing will vary.";
            }

            return "Recommended ASHP size: " + ashpSize + " kW. Estimated price: £" + price;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "There is an error in calculating the ASHP size. Please check the number of rooms you have entered";
        }
    }

    // this is my method for sizing a boiler and getting its price
    public String sizeBoiler(Integer numberOfRooms, Integer numberOfRadiators) {
        if (numberOfRooms == null || numberOfRadiators == null) {
            throw new RuntimeException("Number of rooms and number of radiators cannot be null");
        }

        int boilerSize;
        int price;

        if (numberOfRooms <= 2 && numberOfRadiators <= 10) {
            boilerSize = 24; // or any value between 24-27 kW
            price = 750;
        } else if (numberOfRooms == 3 && numberOfRadiators > 10) {
            boilerSize = 28; // or any value between 28-34 kW
            price = 1150;
        } else if (numberOfRooms >= 4 && numberOfRadiators > 20) {
            boilerSize = 35; // or any value between 35-43 kW
            price = 1550;
        } else {
            return "Custom boiler size required based on property specifics. Pricing will vary.";
        }

        return "Recommended boiler size: " + boilerSize + " kW. Estimated price: £" + price;
    }
}






