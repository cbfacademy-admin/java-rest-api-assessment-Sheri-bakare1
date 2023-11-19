package com.cbfacademy.apiassessment.service;

import com.cbfacademy.apiassessment.model.Recommendation;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;


import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

//This class will handle the list of recommendations of the appliances printed from my heating equipment class


public class JSONFileHandler {

    public static List<Recommendation> readRecommendationsFromFile(String filePath) throws IOException {
        if (!filePath.endsWith(".json")) {
            throw new IllegalArgumentException("This recommendation list requires that you provide a JSON file");
        }

        try (FileReader reader = new FileReader(filePath)) {
            return new Gson().fromJson(reader, new TypeToken<List<Recommendation>>(){}.getType());
        }
    }

    public static void saveRecommendationsToFile(List<Recommendation> recommendations, String filePath) throws IOException {
        if (!filePath.endsWith(".json")) {
            throw new IllegalArgumentException("The output should be a JSON file");
        }

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter(filePath)) {
            gson.toJson(recommendations, writer);
        }
    }
}
