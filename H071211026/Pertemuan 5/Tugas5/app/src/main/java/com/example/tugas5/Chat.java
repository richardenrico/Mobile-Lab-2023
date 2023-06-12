package com.example.tugas5;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Chat {
    private String nama;
    private String nim;

    protected Chat(Parcel in) {
        nama = in.readString();
        nim = in.readString();
    }

    public Chat(String nama, String nim){
        this.nama = nama;
        this.nim = nim;
    }

    public static final Parcelable.Creator<Chat> CREATOR = new Parcelable.Creator<Chat>() {
        @Override
        public Chat Chat(Parcel in) {
            return new Chat(in);
        }

        @Override
        public Chat[] newArray(int size) {
            return new Chat[size];
        }
    };

    public String getNama(){
        return nama;
    }

    public String getNim() {
        return nim;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(nama);
        parcel.writeString(nim);
    }
}
