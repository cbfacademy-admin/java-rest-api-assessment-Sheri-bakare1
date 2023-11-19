package com.cbfacademy.apiassessment.service;
//My logic for selecting thr right appliance

import com.cbfacademy.apiassessment.model.Recommendation;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class HeatingEquipment {

    private ApplianceSelection applianceSelection = new ApplianceSelection();

    public List<Recommendation> getSortedRecommendations(int numberOfRooms, int numberOfRadiators) {
        List<Recommendation> recommendations = new ArrayList<>();

        // This method will add a heat pump recommendation
        Recommendation heatPump = applianceSelection.createHeatPumpRecommendation(numberOfRooms);
        if (heatPump != null) {
            recommendations.add(heatPump);
        }

        // This method will add a boiler recommendation
        Recommendation boiler = applianceSelection.createBoilerRecommendation(numberOfRooms, numberOfRadiators);
        if (boiler != null) {
            recommendations.add(boiler);
        }

        // This method will add a MCHP recommendation
        Recommendation mchp = applianceSelection.createMchpRecommendation(numberOfRooms);
        if (mchp != null) {
            recommendations.add(mchp);
        }

        // This allows the recommendations to be sort by price
        recommendations.sort(Comparator.comparingInt(Recommendation::getPrice));

        return recommendations;
    }

}


