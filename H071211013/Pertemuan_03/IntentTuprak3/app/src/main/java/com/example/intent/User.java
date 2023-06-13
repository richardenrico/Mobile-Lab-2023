package com.example.intent;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class User implements Parcelable {

    String name, username, imageuri, fotouri, capt;

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getImageuri() {
        return imageuri;
    }

    public void setImageuri(String imageuri) {
        this.imageuri = imageuri;
    }

    public String getFotouri() {
        return fotouri;
    }

    public void setFotouri(String fotouri) {
        this.fotouri = fotouri;
    }

    public String getCapt() {
        return capt;
    }

    public void setCapt(String capt) {
        this.capt = capt;
    }

    protected User(Parcel in) {
        name = in.readString();
        username = in.readString();
        imageuri = in.readString();
        fotouri = in.readString();
        capt = in.readString();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(username);
        parcel.writeString(imageuri);
        parcel.writeString(fotouri);
        parcel.writeString(capt);
    }
}
