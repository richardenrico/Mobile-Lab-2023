package com.example.intentassignment.models;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Users implements Parcelable{
    String fullName, userName;
    Uri profile;

    public Users() {

    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Uri getProfile() {
        return profile;
    }

    public void setProfile(Uri profile) {
        this.profile = profile;
    }

    protected Users(Parcel in) {
        fullName = in.readString();
        userName = in.readString();
        profile = in.readParcelable(Uri.class.getClassLoader());
    }

    public static final Creator<Users> CREATOR = new Creator<Users>() {
        @Override
        public Users createFromParcel(Parcel in) {
            return new Users(in);
        }

        @Override
        public Users[] newArray(int size) {
            return new Users[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(fullName);
        parcel.writeString(userName);
        parcel.writeParcelable(profile, i);
    }
}
