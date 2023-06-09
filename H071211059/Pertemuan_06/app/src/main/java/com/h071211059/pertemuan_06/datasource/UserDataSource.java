package com.h071211059.pertemuan_06.datasource;

import android.net.Uri;

import com.h071211059.pertemuan_06.R;
import com.h071211059.pertemuan_06.model.Post;
import com.h071211059.pertemuan_06.model.User;

import java.util.ArrayList;
import java.util.LinkedList;

public class UserDataSource {
    public static ArrayList<User> users = generateUsers();

    private static ArrayList<User> generateUsers() {
        ArrayList<User> users = new ArrayList<>();
        users.add(new User("Arwin", "arwin", R.drawable.u1));
        users.add(new User("Irwin", "irwin", R.drawable.u33));
        users.add(new User("Urwin", "urwin", R.drawable.u42));
        users.add(new User("Erwin", "erwin", R.drawable.u43));
        users.add(new User("Orwin", "orwin", R.drawable.u44));

        ArrayList<Post> posts = new ArrayList<>();
        posts.add(new Post("Beautiful, innit?", Uri.parse("android.resource://com.h071211059.pertemuan_06/drawable/i1")));
        posts.add(new Post("Beautiful, innit?", Uri.parse("android.resource://com.h071211059.pertemuan_06/drawable/i2")));
        posts.add(new Post("Beautiful, innit?", Uri.parse("android.resource://com.h071211059.pertemuan_06/drawable/i3")));
        posts.add(new Post("Beautiful, innit?", Uri.parse("android.resource://com.h071211059.pertemuan_06/drawable/i4")));
        posts.add(new Post("Beautiful, innit?", Uri.parse("android.resource://com.h071211059.pertemuan_06/drawable/i5")));

        for (int i = 0; i < 5; i++) {
            LinkedList<Post> userPosts = new LinkedList<>();
            userPosts.add(posts.get(i));

            users.get(i).setPosts(userPosts);
        }

        return users;
    }
}
