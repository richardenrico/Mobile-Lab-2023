package com.example.backgroundtuprak.datasource;

import com.example.backgroundtuprak.R;
import com.example.backgroundtuprak.model.Post;

import java.util.ArrayList;

public class PostDataSource {
    private static ArrayList<Post> postArrayList;

    public static ArrayList<Post> getPostList() {
        if (postArrayList == null) {
            postArrayList = new ArrayList<>();

            postArrayList.add(new Post(1, R.drawable.dog, "doggie"));
            postArrayList.add(new Post(2, R.drawable.lp1, "landscape"));
            postArrayList.add(new Post(3, R.drawable.lp2, "landscape"));
            postArrayList.add(new Post(4, R.drawable.lp3, "landscape"));
            postArrayList.add(new Post(5, R.drawable.lp4, "landscape"));
        }
        return postArrayList;
    }

    public static void addPost(Post post) {
        postArrayList.add(post);
    }


}
