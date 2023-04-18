package com.example.quizapp.models;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Players implements Parcelable {
    String name;
    int bestScore = 0;
    Uri profile;

    public Players() {
    }

    protected Players(Parcel in) {
        name = in.readString();
        bestScore = in.readInt();
        profile = in.readParcelable(Uri.class.getClassLoader());
    }

    public static final Creator<Players> CREATOR = new Creator<Players>() {
        @Override
        public Players createFromParcel(Parcel in) {
            return new Players(in);
        }

        @Override
        public Players[] newArray(int size) {
            return new Players[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeInt(bestScore);
        parcel.writeParcelable(profile, i);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBestScore() {
        return bestScore;
    }

    public void setBestScore(int bestScore) {
        this.bestScore = bestScore;
    }

    public Uri getProfile() {
        return profile;
    }

    public void setProfile(Uri profile) {
        this.profile = profile;
    }
}
