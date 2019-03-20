package com.example.rayca.my_application_lab_5.model.API;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DoctorApiResponse {

    @SerializedName("DocId")
    @Expose
    private int docId;
    @SerializedName("FullName")
    @Expose
    private String fullName;
    @SerializedName("Specs")
    @Expose
    private String specs;
    @SerializedName("Address")
    @Expose
    private String address;
    @SerializedName("About")
    @Expose
    private String about;
    @SerializedName("Stars")
    @Expose
    private float stars;
    @SerializedName("Photo")
    @Expose
    private String photo;

    public int getDocId() {
        return docId;
    }

    public void setDocId(int docId) {
        this.docId = docId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getSpecs() {
        return specs;
    }

    public void setSpecs(String specs) {
        this.specs = specs;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public float getStars() {
        return stars;
    }

    public void setStars(float stars) {
        this.stars = stars;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

}