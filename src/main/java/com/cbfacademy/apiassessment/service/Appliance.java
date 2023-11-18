package com.cbfacademy.apiassessment.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Appliance {
    // Appliance class properties and methods here
}

public class JSONFileHandler {
    public static List<Appliance> readFile(String filePath) throws IllegalArgumentException {
        if (!filePath.endsWith(".json")) {
            throw new IllegalArgumentException("Error - file must be a JSON file");
        }

        List<Appliance> appliances = new ArrayList<>();
        try (FileReader reader = new FileReader(filePath)) {
            List<Appliance> listOfAppliances = new Gson().fromJson(reader, new TypeToken<List<Appliance>>(){}.getType());
            if (listOfAppliances != null) {
                appliances = listOfAppliances;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return appliances;
    }

    public static void saveToFile(List<Appliance> appliances, String filePath) throws IllegalArgumentException {
        if (!filePath.endsWith(".json")) {
            throw new IllegalArgumentException("Error - output file must be a JSON file");
        }

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter(filePath)) {
            gson.toJson(appliances, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
