package com.pawrescue.pawrescue.entity;

public class RescueRequest {

    private int requestId;
    private String animalType;
    private String description;
    private String location;
    private String status;

    public RescueRequest() {
    }

    public RescueRequest(int requestId, String animalType,
                         String description, String location,
                         String status) {

        this.requestId = requestId;
        this.animalType = animalType;
        this.description = description;
        this.location = location;
        this.status = status;
    }

    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    public String getAnimalType() {
        return animalType;
    }

    public void setAnimalType(String animalType) {
        this.animalType = animalType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}