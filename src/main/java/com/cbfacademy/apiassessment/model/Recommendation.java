package com.cbfacademy.apiassessment.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

public class Recommendation {
    private Appliance appliance;
    private String reason;
    private LocalDateTime timestamp;

    public Appliance getAppliance() {
        return appliance;
    }

    public void setAppliance(Appliance appliance) {
        this.appliance = appliance;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}