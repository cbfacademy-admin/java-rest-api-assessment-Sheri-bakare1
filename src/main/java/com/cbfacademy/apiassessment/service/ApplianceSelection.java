package com.cbfacademy.apiassessment.service;

import com.cbfacademy.apiassessment.model.*;
import com.cbfacademy.apiassessment.repository.ApplianceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;



///This is the logic for selecting the appliance based on the number of rooms and the presence of radiators
@Service
public class ApplianceSelection {

    @Autowired
    private ApplianceRepository repository;

    public Appliance createHeatPumpRecommendation(Integer numberOfRooms, Integer numberOfRadiators) throws IOException {
        if (numberOfRooms == null || numberOfRadiators == null) {
            throw new RuntimeException("Number of rooms cannot be null");
        }
        List<Appliance> applianceList = repository.readAll();
        Optional<Appliance> optional = applianceList.stream().filter(appliance ->
                appliance.getType().equals("HeatPump") &&
                        (appliance.getRooms() == numberOfRooms || appliance.getRadiators() == numberOfRadiators)).findFirst();

        return optional.orElse(null);
    }

    // This method for sizing a boiler and getting its price
    public Appliance createBoilerRecommendation(Integer numberOfRooms, Integer numberOfRadiators) throws IOException {
        if (numberOfRooms == null || numberOfRadiators == null) {
            throw new RuntimeException("Number of rooms and number of radiators cannot be null");
        }

        List<Appliance> applianceList = repository.readAll();
        Optional<Appliance> optional = applianceList.stream().filter(appliance ->
                appliance.getType().equals("Boiler") &&
                        (appliance.getRooms() == numberOfRooms || appliance.getRadiators() == numberOfRadiators)).findFirst();

        return optional.orElse(null);
    }

    // Method for sizing an MCHP and getting its price
    public Appliance createMchpRecommendation(Integer numberOfRooms, Integer numberOfRadiators) throws IOException {
        if (numberOfRooms == null || numberOfRadiators == null) {
            throw new RuntimeException("Number of rooms and number of radiators cannot be null");
        }

        List<Appliance> applianceList = repository.readAll();
        Optional<Appliance> optional = applianceList.stream().filter(appliance ->
                appliance.getType().equals("MCHP") &&
                        (appliance.getRooms() == numberOfRooms || appliance.getRadiators() == numberOfRadiators)).findFirst();

        return optional.orElse(null);
    }
}
