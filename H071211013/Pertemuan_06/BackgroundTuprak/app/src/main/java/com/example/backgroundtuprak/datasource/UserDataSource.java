package com.example.backgroundtuprak.datasource;

import com.example.backgroundtuprak.R;
import com.example.backgroundtuprak.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserDataSource {
    private static ArrayList<User> userArrayList;
    public UserDataSource() {
        userArrayList = new ArrayList<>();
        userArrayList.add(new User(0, "Catie", "cat123", R.drawable.kucing));
        userArrayList.add(new User(1, "Shin Wonho", "wonho", R.drawable.wonho));
        userArrayList.add(new User(2, "Park Sooyoung", "joy", R.drawable.joy));
        userArrayList.add(new User(3, "Hanni", "han610", R.drawable.hanni));
        userArrayList.add(new User(4, "Alexander", "alex", R.drawable.prof));
        userArrayList.add(new User(5, "Jeon Wonwoo", "woo177", R.drawable.wonwoo));
        userArrayList.add(new User(6, "Wang Ziqi", "ziqi", R.drawable.ziqi));
        userArrayList.add(new User(7, "Lalisa Manoban", "lisa97", R.drawable.lisa));
        userArrayList.add(new User(8, "Kimberley Woltemas", "kimmy", R.drawable.kimberley));
        userArrayList.add(new User(9, "Pachara Chirathivat", "peach93", R.drawable.peach));
        userArrayList.add(new User(10, "Warren", "war146", R.drawable.p2));
    }

    public static List<User> getUserArrayList() {
        return userArrayList;
    }

    public static User getUserById(int id) {
        for (User user : userArrayList) {
            if (user.getUserId() == id) {
                return user;
            }
        }
        return null;
    }
}
