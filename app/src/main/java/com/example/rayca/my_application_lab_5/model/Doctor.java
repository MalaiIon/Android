package com.example.rayca.my_application_lab_5.model;

import android.graphics.Bitmap;

import java.io.Serializable;

public class Doctor implements Serializable {
    private int docId;
    private String name;
    private String speciality;
    private String address;
    private float rating;
    private String photo;
    private String shortDescription;


    public Doctor(int docId, String name, String speciality, String address, float rating, String photo, String shortDescription) {
        this.docId = docId;
        this.name = name;
        this.speciality = speciality;
        this.address = address;
        this.rating = rating;
        this.photo = photo;
//        this.photo = photo;
        this.shortDescription = shortDescription;
    }

    public int getDocId() {
        return docId;
    }

    public void setDocId(int docId) {
        this.docId = docId;
    }

    public String getName() {
        return name;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }



//    public String getPhoto() {
//        return photo;
//    }
//
//    public void setPhoto(String photo) {
//        this.photo = photo;
//    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }
}


