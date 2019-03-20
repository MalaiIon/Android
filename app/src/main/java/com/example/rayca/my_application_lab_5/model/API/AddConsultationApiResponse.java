package com.example.rayca.my_application_lab_5.model.API;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AddConsultationApiResponse {
    @SerializedName("ConsId")
    @Expose
    private int consId;
    @SerializedName("Name")
    @Expose
    private String name;
    @SerializedName("Disease")
    @Expose
    private String disease;
    @SerializedName("Address")
    @Expose
    private String address;
    @SerializedName("Description")
    @Expose
    private String description;
    @SerializedName("DocId")
    @Expose
    private int docId;
    @SerializedName("IsConfirmed")
    @Expose
    private boolean isConfirmed;

    public int getConsId() {
        return consId;
    }

    public void setConsId(int consId) {
        this.consId = consId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDocId() {
        return docId;
    }

    public void setDocId(int docId) {
        this.docId = docId;
    }

    public boolean isIsConfirmed() {
        return isConfirmed;
    }

    public void setIsConfirmed(boolean isConfirmed) {
        this.isConfirmed = isConfirmed;
    }
}

