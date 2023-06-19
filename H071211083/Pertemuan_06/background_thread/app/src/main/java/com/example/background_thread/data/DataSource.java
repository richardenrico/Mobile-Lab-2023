package com.example.background_thread.data;

import android.net.Uri;

import com.example.background_thread.R;
import com.example.background_thread.data.model.Post;
import com.example.background_thread.data.model.User;
import com.example.background_thread.R;
import com.example.background_thread.data.model.Post;
import com.example.background_thread.data.model.User;

import java.util.ArrayList;

public class DataSource {
    private static final String BASE_URI = "android.resource://com.example.background_thread/drawable/";
    private ArrayList<User> users = new ArrayList<>();

    public DataSource() {
        this.users.addAll(generateData());
    }


    public ArrayList<User> getUsers() {
        return users;
    }

    private ArrayList<User> generateData() {
        ArrayList<User> users1 = new ArrayList<>();
        for (int i = 0; i < listNames.length; i++) {
            User user = new User(listUsernames[i], listNames[i], listProfilePicture[i],
                    new Post(
                            "Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit...",
                            Uri.parse(BASE_URI + listProfilePicture[i])));

            users1.add(user);
        }
        return users1;
    }

    public void addUser(User user) {
        this.users.add(0, user);
    }

    private String[] listNames = {"warian", "dhevlin", "ikka", "safa", "noel"};
    private String[] listUsernames = {"iann_", "dhev.", "ikka7", "wanaa_", "nlo."};
    private int[] listProfilePicture = {R.drawable.ian, R.drawable.dhev, R.drawable.ikka, R.drawable.safa, R.drawable.noel};
}
