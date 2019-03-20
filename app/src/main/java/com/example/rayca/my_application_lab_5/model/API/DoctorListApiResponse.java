package com.example.rayca.my_application_lab_5.model.API;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DoctorListApiResponse {

    @SerializedName("DoctorList")
    @Expose
    private List<DoctorApiResponse> doctorList;

    public List<DoctorApiResponse> getDoctorList() {
        return doctorList;
    }

    public void setDoctorList(List<DoctorApiResponse> doctorList) {
        this.doctorList = doctorList;
    }
}
