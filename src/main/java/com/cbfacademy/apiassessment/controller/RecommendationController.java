package com.cbfacademy.apiassessment.controller;

import com.cbfacademy.apiassessment.model.Appliance;
import com.cbfacademy.apiassessment.model.Recommendation;
import com.cbfacademy.apiassessment.model.User;
import com.cbfacademy.apiassessment.service.HeatingEquipment;
import com.cbfacademy.apiassessment.service.JSONFileHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

//README.md contains more information on the endpoint
@RestController
@RequestMapping(path = "api/v1/recommendation")
public class RecommendationController {

    // The recommended controller is creating a new instance of the recommendation, based on the criteria which are the number of rooms and the presence of radiators
    //It will sort the recommendation in the HeatingEquipment class to give a list of recommendation
    @GetMapping
    public ResponseEntity recommendations(@RequestParam(value = "rooms") int rooms, @RequestParam(value = "radiators") int radiators) {

        try {
            HeatingEquipment heating = new HeatingEquipment();

            List<Appliance> recommendations = heating.getSortedAppliances(rooms, radiators);

            return ResponseEntity.ok(recommendations);
        } catch (IOException exception) {
            return ResponseEntity.internalServerError().body("Unable to obtain recommendation");
        }
    }
}
