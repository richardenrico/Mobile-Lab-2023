package com.h071211059.pertemuan_03_02;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class User implements Parcelable {
    private final String username;
    private final Uri imageUri;
    private int bestScore;

    public User(String username, Uri imageUri, int bestScore) {
        this.username = username;
        this.imageUri = imageUri;
        this.bestScore = bestScore;
    }

    protected User(Parcel in) {
        username = in.readString();
        imageUri = in.readParcelable(Uri.class.getClassLoader());
        bestScore = in.readInt();
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

    public String getUsername() {
        return username;
    }

    public Uri getImageUri() {
        return imageUri;
    }

    public int getBestScore() {
        return bestScore;
    }

    public void setBestScore(int bestScore) {
        this.bestScore = bestScore;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(username);
        parcel.writeParcelable(imageUri, i);
        parcel.writeInt(bestScore);
    }
}
