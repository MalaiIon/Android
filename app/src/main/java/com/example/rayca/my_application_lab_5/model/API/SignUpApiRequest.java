package com.example.rayca.my_application_lab_5.model.API;

import com.google.gson.annotations.SerializedName;

public class SignUpApiRequest {

    @SerializedName("FullName")
    String FullName;

    @SerializedName("Birthday")
    String Birthday;

    @SerializedName("Email")
    String Email;

    @SerializedName("Phone")
    String Phone;

    @SerializedName("Address")
    String Address;

    @SerializedName("Username")
    String Username;

    @SerializedName("Password")
    String Password;

    @SerializedName("Base64Photo")
    String Base64Photo;

    public SignUpApiRequest(String fullName, String birthday, String email, String phone, String address, String username, String password, String base64Photo) {
        FullName = fullName;
        Birthday = birthday;
        Email = email;
        Phone = phone;
        Address = address;
        Username = username;
        Password = password;
        Base64Photo = base64Photo;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    public String getBirthday() {
        return Birthday;
    }

    public void setBirthday(String birthday) {
        Birthday = birthday;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getBase64Photo() {
        return Base64Photo;
    }

    public void setBase64Photo(String base64Photo) {
        Base64Photo = base64Photo;
    }
}