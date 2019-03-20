package com.example.rayca.my_application_lab_5.api;

import com.example.rayca.my_application_lab_5.model.API.AddConsultationApiRequest;
import com.example.rayca.my_application_lab_5.model.API.AddConsultationApiResponse;
import com.example.rayca.my_application_lab_5.model.API.DoctorApiResponse;
import com.example.rayca.my_application_lab_5.model.API.DoctorListApiResponse;
import com.example.rayca.my_application_lab_5.model.API.LoginApiRequest;
import com.example.rayca.my_application_lab_5.model.API.LoginUserApiResponse;
import com.example.rayca.my_application_lab_5.model.API.ProfileApiResponse;
import com.example.rayca.my_application_lab_5.model.API.SignUpApiRequest;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.*;


public interface TelemedicineAPI {
    @Headers({"Content-Type: application/json"})
    @POST("/api/Register/UserReg")
    Call<String> registerUser(@Body SignUpApiRequest signUpApiRequest);

    @Headers({"Content-Type: application/json"})
    @POST("/api/Login/UserAuth")
    Call<LoginUserApiResponse> loginUser(@Body LoginApiRequest loginApiRequest);

    @Headers({"Content-Type: application/x-www-form-urlencoded"})
    @GET("/api/Profile/GetProfile")
    Call<ProfileApiResponse> getProfile(@Header("token") String token);

    @Headers({"Content-Type: application/x-www-form-urlencoded"})
    @GET("/api/Doctor/GetDoctorList")
    Call<List<DoctorApiResponse>> getDoctorList(@Header("token") String token);

    @Headers({"Content-Type: application/x-www-form-urlencoded"})
    @POST("/api/Doctor/AddConsultation")
    Call<AddConsultationApiResponse> addConsultation (@Header("token") String token, @Body AddConsultationApiRequest addConsultationApiRequest);
}
