package com.h071211059.pertemuan_07.models;

import com.google.gson.annotations.SerializedName;

public class UserDataResponse {
    @SerializedName("data")
    private UserResponse userResponse;

    public UserResponse getData() {
        return userResponse;
    }
}
