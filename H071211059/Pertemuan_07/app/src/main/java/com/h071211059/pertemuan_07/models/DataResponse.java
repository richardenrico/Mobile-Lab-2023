package com.h071211059.pertemuan_07.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class DataResponse {
    @SerializedName("data")
    private ArrayList<UserResponse> data;

    public ArrayList<UserResponse> getData() {
        return data;
    }
}
