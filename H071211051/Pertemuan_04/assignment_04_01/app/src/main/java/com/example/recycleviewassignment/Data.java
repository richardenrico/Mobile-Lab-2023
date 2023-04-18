package com.example.recycleviewassignment;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Data implements Parcelable {
    private String name;
    private String message;
    private String time;
    private String photo_profile;
    private String status;
    private String status_date;

    public Data(String name, String message, String photo_profile, String time, String status, String status_date) {
        this.name = name;
        this.message = message;
        this.photo_profile = photo_profile;
        this.time = time;
        this.status = status;
        this.status_date = status_date;
    }

    protected Data(Parcel in) {
        name = in.readString();
        message = in.readString();
        photo_profile = in.readString();
        time = in.readString();
        status = in.readString();
        status_date = in.readString();
    }

   public static final Creator<Data> CREATOR = new Creator<Data>() {
        @Override
        public Data createFromParcel(Parcel in) {
            return new Data(in);
        }

        @Override
        public Data[] newArray(int size) {
            return new Data[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(message);
        parcel.writeString(photo_profile);
        parcel.writeString(time);
        parcel.writeString(status);
        parcel.writeString(status_date);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPhoto_profile() {
        return photo_profile;
    }

    public void setPhoto_profile(String photo_profile) {
        this.photo_profile = photo_profile;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus_date() {
        return status_date;
    }

    public void setStatus_date(String status_date) {
        this.status_date = status_date;
    }
}
