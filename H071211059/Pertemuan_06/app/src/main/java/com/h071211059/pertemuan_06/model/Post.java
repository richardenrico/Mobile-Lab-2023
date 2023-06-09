package com.h071211059.pertemuan_06.model;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

public class Post implements Parcelable {
    private String caption;
    private Uri imageUri;

    public Post(String caption, Uri imageUri) {
        this.caption = caption;
        this.imageUri = imageUri;
    }

    public Post(Uri imageUri) {
        this.imageUri = imageUri;
    }

    public String getCaption() {
        return caption;
    }

    public Uri getImageUri() {
        return imageUri;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public void setImageUri(Uri imageUri) {
        this.imageUri = imageUri;
    }

    protected Post(Parcel in) {
        caption = in.readString();
        imageUri = in.readParcelable(Uri.class.getClassLoader());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(caption);
        dest.writeParcelable(imageUri, flags);
    }

    @Override
    public int describeContents() {
        return 0;
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

}
