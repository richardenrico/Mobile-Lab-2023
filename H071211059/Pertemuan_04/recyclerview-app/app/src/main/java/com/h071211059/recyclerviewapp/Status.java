package com.h071211059.recyclerviewapp;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Status implements Parcelable {
    private String statusText;
    private String statusTime;

    public Status(String statusText, String statusTime) {
        this.statusText = statusText;
        this.statusTime = statusTime;
    }

    protected Status(Parcel in) {
        statusText = in.readString();
        statusTime = in.readString();
    }

    public static final Creator<Status> CREATOR = new Creator<Status>() {
        @Override
        public Status createFromParcel(Parcel in) {
            return new Status(in);
        }

        @Override
        public Status[] newArray(int size) {
            return new Status[size];
        }
    };

    public String getStatusText() {
        return statusText;
    }

    public void setStatusText(String statusText) {
        this.statusText = statusText;
    }

    public String getStatusTime() {
        return statusTime;
    }

    public void setStatusTime(String statusTime) {
        this.statusTime = statusTime;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(statusText);
        parcel.writeString(statusTime);
    }
}
