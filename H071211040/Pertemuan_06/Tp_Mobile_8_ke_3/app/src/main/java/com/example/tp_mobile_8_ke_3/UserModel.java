package com.example.tp_mobile_8_ke_3;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class UserModel implements Parcelable {
    String name;
    String username;
    int profilePicture;
    PostModel postModel;

    public UserModel() {

    }

    public String getName() {
        return name;
    }
    public String getUsername() {
        return username;
    }
    public int getProfilePicture() {
        return profilePicture;
    }
    public PostModel getPost() {
        return postModel;
    }


    public UserModel(String name, String username, int profilePicture, PostModel postModel) {
        this.name = name;
        this.username = username;
        this.profilePicture = profilePicture;
        this.postModel = postModel;
    }

    protected UserModel(Parcel in) {
        name = in.readString();
        username = in.readString();
        profilePicture = in.readInt();
        postModel = in.readParcelable(PostModel.class.getClassLoader());
    }

    public static final Creator<UserModel> CREATOR = new Creator<UserModel>() {
        @Override
        public UserModel createFromParcel(Parcel in) {
            return new UserModel(in);
        }

        @Override
        public UserModel[] newArray(int size) {
            return new UserModel[size];
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
        parcel.writeInt(profilePicture);
        parcel.writeParcelable(postModel, i);
    }
}