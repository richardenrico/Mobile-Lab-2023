package com.example.tp_mobile_9;

import com.google.gson.annotations.SerializedName;

public class UserResponse {
    @SerializedName("id")
    private int id;
    @SerializedName("avatar")
    private String avatarUrl;
    @SerializedName("first_name")
    private String firstName;
    @SerializedName("last_name")
    private String lastName;
    @SerializedName("email")
    private String email;

    public int getId() {
        return id;
    }
    public String getAvatarUrl() {
        return avatarUrl;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getEmail() {
        return email;
    }


}
