package com.example.background_thread.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;

public class User implements Parcelable{
    private String username;
    private String fullname;
    @DrawableRes
    private int profile;
    private Post post;

    public User(String username, String fullname, int profile,  Post post){
        this.username = username;
        this.fullname = fullname;
        this.profile = profile;
        this.post = post;
    }

    public User(){

    }

    protected User(Parcel in) {
        username = in.readString();
        fullname = in.readString();
        profile = in.readInt();
        post = in.readParcelable(Post.class.getClassLoader());
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

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public int getProfile() {
        return profile;
    }

    public void setProfile(int profile) {
        this.profile = profile;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(username);
        parcel.writeString(fullname);
        parcel.writeInt(profile);
        parcel.writeParcelable(post, i);
    }
}
