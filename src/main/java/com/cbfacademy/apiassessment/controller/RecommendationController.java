package com.cbfacademy.apiassessment.controller;

import com.cbfacademy.apiassessment.model.Appliance;
import com.cbfacademy.apiassessment.model.Recommendation;
import com.cbfacademy.apiassessment.model.User;
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
public class RecommendationController {
    @GetMapping("/")
    public ResponseEntity hello() {
        return ResponseEntity.ok("Hello Mum");

    }
    @GetMapping("/recommendations")
    public ResponseEntity recommendations() {
        Appliance A = new Appliance();
        A.setName("Heat Pump");
        A.setDescription("This is a Heat Pump");
        A.setVolume(100);
        A.setSize(2);

        Recommendation rec = new Recommendation();
        rec.setAppliance (A);
        rec.setReason("This is best suited for you based on the number of people in you household");
        rec.setTimestamp(LocalDateTime.now());
        return ResponseEntity.ok(rec);

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

    @RestController
    @RequestMapping(path = "api/v1/recommendation")
    public class RecommendedController {
        @GetMapping
        public ResponseEntity<Recommendation> recommendations() {
            // This creates a new appliance
            Appliance appliance = new Appliance();
            appliance.setName("Heat Pump");
            appliance.setDescription("This is a Heat Pump");
            appliance.setVolume(100);
            appliance.setSize(2);

            // This creates a new recommendation
            Recommendation recommendation = new Recommendation();
            recommendation.setAppliance(appliance);
            recommendation.setReason("This is best suited for you based on the number of people in your household");
            recommendation.setTimestamp(LocalDateTime.now());

            // This is return the recommendation wrapped in a ResponseEntity
            return ResponseEntity.ok(recommendation);
        }
    }
}
