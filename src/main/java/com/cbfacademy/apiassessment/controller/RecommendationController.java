package com.cbfacademy.apiassessment.controller;

import com.cbfacademy.apiassessment.model.Appliance;
import com.cbfacademy.apiassessment.model.Recommendation;
import com.cbfacademy.apiassessment.model.User;
import com.cbfacademy.apiassessment.service.HeatingEquipment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/recommendation")
public class RecommendationController {

    // The recommended controller is creating a new instance of the recommendation, based on the criteria which are the number of rooms and the presence of radiators
    //It will sort the recommendation in the HeatingEquipment class to give a list of recommendation
    @GetMapping
    public ResponseEntity<List<Recommendation>> recommendations() {
        HeatingEquipment heating = new HeatingEquipment();

        int numberOfRooms = 2;
        int numberOfRadiators = 0;

        List<Recommendation> recommendations = heating.getSortedRecommendations(numberOfRooms, numberOfRadiators);

        return ResponseEntity.ok(recommendations);
    }

    @GetMapping("/user")
    public List<User> profile() {
        return List.of(
                new User(
                        1L,
                        "Lily",
                        30,
                        LocalDate.of(1993, Month.JUNE, 20),
                        "lily.williams@gmail.com"
                )
        );
    }

}
