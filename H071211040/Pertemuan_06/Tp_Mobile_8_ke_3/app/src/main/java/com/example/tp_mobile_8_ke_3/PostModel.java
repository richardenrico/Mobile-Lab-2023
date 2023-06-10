package com.example.tp_mobile_8_ke_3;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class PostModel implements Parcelable{
    public String caption;
    public Uri imagePost;

    public PostModel(String caption, Uri img_post) {
        this.caption = caption;
        this.imagePost = img_post;
    }

    public PostModel() {
    }

    protected PostModel(Parcel in) {
        caption = in.readString();
        imagePost = in.readParcelable(Uri.class.getClassLoader());
    }

    public static final Parcelable.Creator<PostModel> CREATOR = new Parcelable.Creator<PostModel>() {
        @Override
        public PostModel createFromParcel(Parcel in) {
            return new PostModel(in);
        }

        @Override
        public PostModel[] newArray(int size) {
            return new PostModel[size];
        }
    };

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public Uri getImg_post() {
        return imagePost;
    }

    public void setImg_post(Uri img_post) {
        this.imagePost = img_post;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(caption);
        parcel.writeParcelable(imagePost, i);
    }
}
