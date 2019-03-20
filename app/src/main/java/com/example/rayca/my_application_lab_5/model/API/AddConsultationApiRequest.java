package com.example.rayca.my_application_lab_5.model.API;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AddConsultationApiRequest {

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

    /**
     * No args constructor for use in serialization
     *
     */
    public AddConsultationApiRequest() {
    }

    /**
     *
     * @param address
     * @param description
     * @param name
     * @param docId
     * @param disease
     */
    public AddConsultationApiRequest(String name, String disease, String address, String description, int docId) {
        super();
        this.name = name;
        this.disease = disease;
        this.address = address;
        this.description = description;
        this.docId = docId;
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
}
