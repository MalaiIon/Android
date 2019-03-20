package com.example.rayca.my_application_lab_5.model;

import java.io.Serializable;

public class Consultation implements Serializable {

    private String name;
    private String disease;
    private String location;
    private String description;

    public Consultation() {}

    public Consultation(String name, String disease, String location, String description) {
        this.name = name;
        this.disease = disease;
        this.location = location;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public Consultation setName(String name) {
        this.name = name;
        return this;
    }

    public String getDisease() {
        return disease;
    }

    public Consultation setDisease(String disease) {
        this.disease = disease;
        return this;
    }

    public String getLocation() {
        return location;
    }

    public Consultation setLocation(String location) {
        this.location = location;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Consultation setDescription(String description) {
        this.description = description;
        return this;
    }
}
