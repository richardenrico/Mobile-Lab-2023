package com.example.fragmenttuprak;

import com.example.fragmenttuprak.model.Post;

import java.util.ArrayList;

public class PostArrayList {
    private static final PostArrayList instance = new PostArrayList();
    private static ArrayList<Post> postArrayList;

    private PostArrayList() {
        postArrayList = new ArrayList<>();
    }

    public static PostArrayList getInstance() {
        return instance;
    }

    public ArrayList<Post> getPostArrayList() {
        return postArrayList;
    }

    public static void addPost(Post post) {
        postArrayList.add(post);
    }

    public interface OnPostAddedListener {
        void onPostAdded(Post post);

    }
}
