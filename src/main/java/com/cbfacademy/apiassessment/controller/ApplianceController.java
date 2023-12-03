package com.cbfacademy.apiassessment.controller;

import com.cbfacademy.apiassessment.model.Appliance;
import com.cbfacademy.apiassessment.repository.ApplianceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping(path = "api/v1/appliance")
public class ApplianceController {

    @Autowired
    private ApplianceRepository repository;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody Appliance appliance) {
        try {
            appliance = repository.create(appliance);
            return ResponseEntity.ok(appliance);
        } catch (IOException e) {
            return ResponseEntity.internalServerError().body("Unable to save appliance");
        }
    }

    @GetMapping("/read")
    public ResponseEntity<?> read(@RequestParam(value = "id") int id) {
        try {
            Appliance appliance = repository.read(id);
            return ResponseEntity.ok(appliance);
        } catch (IOException e) {
            return ResponseEntity.internalServerError().body("Unable to save appliance");
        }
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody Appliance appliance) {

        try {
            appliance = repository.update(appliance);
            return ResponseEntity.ok(appliance);
        } catch (IOException e) {
            return ResponseEntity.internalServerError().body("Unable to save appliance");
        }

    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestParam(value = "id") int id) {

        try {
            repository.delete(id);
            return ResponseEntity.ok().build();
        } catch (IOException e) {
            return ResponseEntity.internalServerError().body("Unable to save appliance");
        }
    }
}
