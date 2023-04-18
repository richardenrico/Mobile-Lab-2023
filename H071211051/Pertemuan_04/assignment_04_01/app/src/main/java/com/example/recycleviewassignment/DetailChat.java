package com.example.recycleviewassignment;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class DetailChat implements Parcelable {


    private String chat, time;
    private boolean isLeft;

    public DetailChat(String chat, String time, boolean isLeft) {
        this.chat = chat;
        this.time = time;
        this.isLeft = isLeft;
    }

    protected DetailChat(Parcel in) {
        chat = in.readString();
        time = in.readString();
        isLeft = in.readByte() != 0;
    }

    public static final Creator<DetailChat> CREATOR = new Creator<DetailChat>() {
        @Override
        public DetailChat createFromParcel(Parcel in) {
            return new DetailChat(in);
        }

        @Override
        public DetailChat[] newArray(int size) {
            return new DetailChat[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(chat);
        parcel.writeString(time);
        parcel.writeByte((byte) (isLeft ? 1 : 0));
    }

    public String getChat() {
        return chat;
    }

    public void setChat(String chat) {
        this.chat = chat;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public boolean isLeft() {
        return isLeft;
    }

    public void setLeft(boolean left) {
        isLeft = left;
    }

}
