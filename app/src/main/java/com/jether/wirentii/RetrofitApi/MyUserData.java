package com.jether.wirentii.RetrofitApi;

import com.google.gson.annotations.SerializedName;

public class MyUserData {

    @SerializedName("FullName")
    public String name;

    @SerializedName("Email")
    public String email;

    public MyUserData(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "MyUserData{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}