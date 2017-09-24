package com.example.android.jindalfresh.app_activities.auth;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class SignUpModel implements Serializable {

    private String password;
    private String email;

    @SerializedName("first_name")
    private String firstName;

    @SerializedName("last_name")
    private String lastName;
    private String address_one;
    private String address_two;
    private String street;
    private String landmark;
    private String district;
    private String city;
    private String state;
    private String pincode;


    //==========Address====================================================
    private String phonenumber;
    private String phonenumber_two;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public String getFullAddress() {
        return
                getAddress_one() + " " +
                        getAddress_two() + " " +
                        getStreet() + " " +
                        getLandmark() + " " +
                        getDistrict() + " " +
                        getCity() + " " +
                        getState() + " " +
                        getPincode();
    }

    public String getAddress_one() {
        return address_one;
    }

    public void setAddress_one(String address_one) {
        this.address_one = address_one;
    }

    public String getAddress_two() {
        return address_two;
    }

    public void setAddress_two(String address_two) {
        this.address_two = address_two;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getLandmark() {
        return landmark;
    }

    public void setLandmark(String landmark) {
        this.landmark = landmark;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getPhonenumber_two() {
        return phonenumber_two;
    }

    public void setPhonenumber_two(String phonenumber_two) {
        this.phonenumber_two = phonenumber_two;
    }


}
