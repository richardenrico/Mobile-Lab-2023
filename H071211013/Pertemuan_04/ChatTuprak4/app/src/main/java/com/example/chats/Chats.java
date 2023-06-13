package com.example.chats;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Chats implements Parcelable {
    String nama, chat, jam, number, status, tgl_stat;
    int img;

    public Chats(String nama, String chat, String jam, String number, String status, String tgl_stat, int img) {
        this.nama = nama;
        this.chat = chat;
        this.jam = jam;
        this.number = number;
        this.status = status;
        this.tgl_stat = tgl_stat;
        this.img = img;
    }


    protected Chats(Parcel in) {
        nama = in.readString();
        chat = in.readString();
        jam = in.readString();
        number = in.readString();
        status = in.readString();
        tgl_stat = in.readString();
        img = in.readInt();
    }

    public static final Creator<Chats> CREATOR = new Creator<Chats>() {
        @Override
        public Chats createFromParcel(Parcel in) {
            return new Chats(in);
        }

        @Override
        public Chats[] newArray(int size) {
            return new Chats[size];
        }
    };

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getChat() {
        return chat;
    }

    public void setChat(String chat) {
        this.chat = chat;
    }

    public String getJam() {
        return jam;
    }

    public void setJam(String jam) {
        this.jam = jam;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTgl_stat() {
        return tgl_stat;
    }

    public void setTgl_stat(String tgl_stat) {
        this.tgl_stat = tgl_stat;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(nama);
        parcel.writeString(chat);
        parcel.writeString(jam);
        parcel.writeString(number);
        parcel.writeString(status);
        parcel.writeString(tgl_stat);
        parcel.writeInt(img);
    }
}
