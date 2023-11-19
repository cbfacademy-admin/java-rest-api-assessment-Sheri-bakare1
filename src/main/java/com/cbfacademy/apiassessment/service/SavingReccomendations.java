package com.cbfacademy.apiassessment.service;
import java.io.IOException;
import java.util.List;

public class HeatingEquipmentOutput {
    public static void main(String[] args) {
        HeatingEquipment heatingEquipment = new HeatingEquipment();
        int numberOfRooms = 2;
        int numberOfRadiators = 3;

        List<Recommendation> recommendations = heatingEquipment.getSortedRecommendations(numberOfRooms, numberOfRadiators);

        try {
            JSONFileHandler.saveRecommendationsToFile(recommendations, "/Users/sherib/cbfacademy/java-rest-api-assessment-Sheri-bakare1/src/main/repository.json");
        } catch (IOException e) {
            e.printStackTrace();

        }
    }
}
