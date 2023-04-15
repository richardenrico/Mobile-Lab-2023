package com.example.quiz;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class User implements Parcelable {
    String nama, imgUri;
    int score = 0, bscore = 0;

    public User() {

    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getImgUri() {
        return imgUri;
    }

    public void setImgUri(String imgUri) {
        this.imgUri = imgUri;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getBscore() {
        return bscore;
    }

    public void setBscore(int bscore) {
        this.bscore = bscore;
    }

    protected User(Parcel in) {
        nama = in.readString();
        imgUri = in.readString();
        score = in.readInt();
        bscore = in.readInt();
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
        parcel.writeString(nama);
        parcel.writeString(imgUri);
        parcel.writeInt(score);
        parcel.writeInt(bscore);
    }


}
