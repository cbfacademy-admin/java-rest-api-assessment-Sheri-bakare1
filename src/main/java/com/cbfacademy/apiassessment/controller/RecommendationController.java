package com.cbfacademy.apiassessment.controller;

import com.cbfacademy.apiassessment.model.Appliance;
import com.cbfacademy.apiassessment.model.Recommendation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

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
}
