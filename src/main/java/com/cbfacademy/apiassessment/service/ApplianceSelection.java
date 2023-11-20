package com.cbfacademy.apiassessment.service;

import com.cbfacademy.apiassessment.model.*;
import com.cbfacademy.apiassessment.repository.ApplianceRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

///This is the logic for selecting the appliance based on the number of rooms and the presence of radiators
public class ApplianceSelection {

    @Autowired
    private ApplianceRepository repository;

    public Appliance createHeatPumpRecommendation(Integer numberOfRooms, Integer numberOfRadiators) throws IOException {
        if (numberOfRooms == null) {
            throw new RuntimeException("Number of rooms cannot be null");
        }
        List<Appliance> applianceList = repository.readAll();
        Optional<Appliance> optional = applianceList.stream().filter(appliance ->
                appliance.getType().equals("HeatPump") &&
                        (appliance.getRooms() == numberOfRooms || appliance.getRadiators() == numberOfRadiators)).findFirst();

        return optional.orElse(null);
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
        Boiler boiler = new Boiler("Boiler Name", "Boiler Description", "Boiler Type", boilerSize, numberOfRooms, numberOfRadiators);

        return new Recommendation(boiler, price);
    }

    // Method for sizing an MCHP and getting its price
    public Recommendation createMchpRecommendation(Integer numberOfRooms, Integer numberOfRadiators) {
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
        MCHP mchp = new MCHP("MCHP Name", "MCHP Description", "MCHP Type", mchpSize, numberOfRooms, numberOfRadiators);


        return new Recommendation(mchp, price);
    }
}
