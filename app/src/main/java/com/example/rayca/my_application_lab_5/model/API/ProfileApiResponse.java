package com.example.rayca.my_application_lab_5.model.API;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProfileApiResponse {

    @SerializedName("FullName")
    @Expose
    private String fullName;
    @SerializedName("Birthday")
    @Expose
    private String birthday;
    @SerializedName("Email")
    @Expose
    private String email;
    @SerializedName("Phone")
    @Expose
    private String phone;
    @SerializedName("Address")
    @Expose
    private String address;
    @SerializedName("Username")
    @Expose
    private String username;
    @SerializedName("Base64Photo")
    @Expose
    private String base64Photo;
    @SerializedName("Status")
    @Expose
    private Object status;

    public ProfileApiResponse() {}

    /**
     *
     * @param birthday
     * @param username
     * @param phone
     * @param status
     * @param address
     * @param email
     * @param fullName
     * @param base64Photo
     */
    public ProfileApiResponse(String fullName, String birthday, String email, String phone, String address, String username, String base64Photo, Object status) {
        super();
        this.fullName = fullName;
        this.birthday = birthday;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.username = username;
        this.base64Photo = base64Photo;
        this.status = status;
    }


    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getBase64Photo() {
        return base64Photo;
    }

    public void setBase64Photo(String base64Photo) {
        this.base64Photo = base64Photo;
    }

    public Object getStatus() {
        return status;
    }

    public void setStatus(Object status) {
        this.status = status;
    }

}
