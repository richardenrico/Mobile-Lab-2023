package com.example.tp_mobile_9;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DataResponse {
    @SerializedName("data")
    private List<UserResponse> data;

    public List<UserResponse> getData() {
        return data;
    }
}

