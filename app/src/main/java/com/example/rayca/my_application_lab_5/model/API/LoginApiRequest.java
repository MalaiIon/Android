package com.example.rayca.my_application_lab_5.model.API;

import com.google.gson.annotations.SerializedName;

public class LoginApiRequest {

    @SerializedName("Email")
    private String email;

    @SerializedName("Password")
    private String password;

    public LoginApiRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
