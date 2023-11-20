package com.cbfacademy.apiassessment.service;
//My logic for selecting thr right appliance

import com.cbfacademy.apiassessment.model.Appliance;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class HeatingEquipment {

    private ApplianceSelection applianceSelection = new ApplianceSelection();

    public List<Appliance> getSortedAppliances(int numberOfRooms, int numberOfRadiators) throws IOException {
        List<Appliance> appliances = new ArrayList<>();

        // This method will add a heat pump appliance
        Appliance heatPump = applianceSelection.createHeatPumpRecommendation(numberOfRooms,numberOfRadiators);
        if (heatPump != null) {
            appliances.add(heatPump);
        }

        // This method will add a boiler appliance
        Appliance boiler = applianceSelection.createBoilerRecommendation(numberOfRooms, numberOfRadiators);
        if (boiler != null) {
            appliances.add(boiler);
        }

        // This method will add a MCHP appliance
        Appliance mchp = applianceSelection.createMchpRecommendation(numberOfRooms,numberOfRadiators);
        if (mchp != null) {
            appliances.add(mchp);
        }

        // This allows the appliances to be sort by price
        appliances.sort(Comparator.comparingInt(Appliance::getPrice));

        return appliances;
    }

}


