package com.cbfacademy.apiassessment.repository;

import com.cbfacademy.apiassessment.model.Appliance;
import com.cbfacademy.apiassessment.service.JSONFileHandler;
import org.springframework.stereotype.Repository;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Repository
public class ApplianceRepository {

    private String path = "/Users/sherib/cbfacademy/java-rest-api-assessment-Sheri-bakare1/src/main/resources/repository.json";

    public Appliance create(Appliance appliance) throws IOException {
        List<Appliance> applianceList = readAll();
        appliance.setId(applianceList.size()+1);
        applianceList.add(appliance);
        JSONFileHandler.saveAppliancesToFile(applianceList, path);
        return appliance;
    }
// we have a list of appliances and it's looping to match the id and will update it
    public Appliance read(int id) throws IOException {
        List<Appliance> applianceList = readAll();
        Optional<Appliance> optional = applianceList.stream().filter(appliance -> appliance.getId() == id).findFirst();
        return optional.orElse(null);
    }

    public List<Appliance>readAll() throws IOException {
        return JSONFileHandler.readAppliancesFromFile(path);
    }

    public Appliance update( Appliance appliance) throws IOException {
        List<Appliance> applianceList = readAll();
        int index = applianceList.indexOf(appliance);
        applianceList.remove(appliance);
        applianceList.add(index, appliance);
        JSONFileHandler.saveAppliancesToFile(applianceList, path);
        return appliance;
    }

    public void delete(int id) throws IOException {
        List<Appliance> applianceList = readAll();
        Optional<Appliance> optional = applianceList.stream().filter(appliance -> appliance.getId() == id).findFirst();
        Appliance appliance = optional.get();
        int index = applianceList.indexOf(appliance);
        applianceList.remove(appliance);
        JSONFileHandler.saveAppliancesToFile(applianceList, path);
    }
}
