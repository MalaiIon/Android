package com.example.rayca.my_application_lab_5.model;

import java.io.Serializable;

public class Profile implements Serializable {

    private String fullName;
    private String birthday;
    private String email;
    private String phone;
    private String address;
    private String username;
    private String base64Photo;
    private Object status;

    public Profile() {}

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
    public Profile(String fullName, String birthday, String email, String phone, String address, String username, String base64Photo, Object status) {
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

