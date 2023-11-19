package com.cbfacademy.apiassessment.service;

import com.google.gson.Gson;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

//I'm hoping to get a list of appliances printed from my heating equipment child class
import com.google.gson.reflect.TypeToken;
import com.google.gson.GsonBuilder;

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
