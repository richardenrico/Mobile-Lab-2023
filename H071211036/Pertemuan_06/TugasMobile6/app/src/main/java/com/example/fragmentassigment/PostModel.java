package com.example.fragmentassigment;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class PostModel implements Parcelable {
    private String username;
    private String name;
    private String caption;
    private String profile;
    private String header;
    private String desc;
    private String upload;

    public PostModel(String username, String name, String caption, String profile, String header, String desc, String upload) {
        this.username = username;
        this.name = name;
        this.caption = caption;
        this.profile = profile;
        this.header = header;
        this.desc = desc;
        this.upload = upload;
    }

    protected PostModel(Parcel in) {
        username = in.readString();
        name = in.readString();
        caption = in.readString();
        profile = in.readString();
        header = in.readString();
        desc = in.readString();
        upload = in.readString();
    }

    public static final Creator<PostModel> CREATOR = new Creator<PostModel>() {
        @Override
        public PostModel createFromParcel(Parcel in) {
            return new PostModel(in);
        }

        @Override
        public PostModel[] newArray(int size) {
            return new PostModel[size];
        }
    };

    public String getProfile() {
        return profile;
    }

    public String getHeader() {
        return header;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getUpload() {
        return upload;
    }

    public String getCaption() {
        return caption;
    }

    public String getDesc() { return desc; }

    public void setImageUri(String profile) {
        this.profile = profile;
    }

    public void setHeader(String header) { this.header = header; }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public void setDesc(String desc) { this.desc = desc; }

    public void setName(String name) {
        this.name = name;
    }

    public void setImageUri1(String upload) {
        this.upload = upload;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(username);
        parcel.writeString(name);
        parcel.writeString(caption);
        parcel.writeString(profile);
        parcel.writeString(header);
        parcel.writeString(desc);
        parcel.writeString(upload);
    }
}