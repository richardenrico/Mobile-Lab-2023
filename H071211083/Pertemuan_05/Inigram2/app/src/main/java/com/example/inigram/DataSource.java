package com.example.inigram;

import java.util.ArrayList;

public class DataSource {
    static ArrayList<PostModel> posts = new ArrayList<>();

    public static void addPost (PostModel post){
        posts.add(post);

    }

    public static ArrayList<PostModel> getPosts() {
        return posts;
    }
}
