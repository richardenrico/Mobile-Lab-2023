package com.example.tp_mobile_7;

import android.media.Image;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.widget.ImageView;

import androidx.annotation.NonNull;

public class Post implements Parcelable {

//    int profilePicture;
//    String userName, fullName;
    String caption;
    Uri imagePost;

    public Post(String caption, Uri imagePost ) {
//        this.profilePicture = profilePicture;
        this.caption = caption;
//        this.userName = userName;
//        this.fullName = fullName;
        this.imagePost = imagePost;
    }

    protected Post(Parcel in) {
//        profilePicture = in.readInt();
        caption = in.readString();
//        userName = in.readString();
//        fullName = in.readString();
        imagePost = in.readParcelable(Uri.class.getClassLoader());
    }

    public static final Creator<Post> CREATOR = new Creator<Post>() {
        @Override
        public Post createFromParcel(Parcel in) {
            return new Post(in);
        }

        @Override
        public Post[] newArray(int size) {
            return new Post[size];
        }
    };

//    public int getProfilePicture() {
//        return profilePicture;
//    }
    public String getCaption() {
        return caption;
    }

//    public String getUserName() {
//        return userName;
//    }

//    public String getFullName() {
//        return fullName;
//    }

    public Uri getImagePost() {
        return imagePost;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
//        parcel.writeInt(profilePicture);
        parcel.writeString(caption);
//        parcel.writeString(userName);
//        parcel.writeString(fullName);
        parcel.writeParcelable(imagePost, i);
    }
}
