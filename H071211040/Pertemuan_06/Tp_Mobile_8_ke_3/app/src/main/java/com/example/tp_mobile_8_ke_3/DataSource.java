package com.example.tp_mobile_8_ke_3;

import android.net.Uri;

import java.util.ArrayList;

public class DataSource {
    private static final String URI_CONST = "android.resource://com.example.tp_mobile_8_ke_3/mipmap/";
    private ArrayList<UserModel> users = new ArrayList<>();

    public DataSource() {
        this.users.addAll(generateData());
    }

    public ArrayList<UserModel> getUsers() {

        return users;
    }

    public void addUser(UserModel user) {

        users.add(0, user);
    }

    private ArrayList<UserModel> generateData() {

        ArrayList<UserModel> userArrayList = new ArrayList<>();

        for (int i = 0; i < names.length; i++) {

            UserModel user = new UserModel(usernames[i], names[i], profilePictures[i],
                    new PostModel(
                            "The sound of waves crashing against the shore creates a soothing rhythm that lulls me to sleep.",
                            Uri.parse(URI_CONST + profilePictures[i]))
            );

            userArrayList.add(user);
        }

        return userArrayList;
    }

    private final String[] usernames = {
            "Aatrox",
            "Akali",
            "Azir",
            "Kayn",
            "Nasus",
            "Pantheon",
            "Renekton",
            "Thresh",
            "Yasuo",
            "Yone"};
    private final String[] names = {
            "The Darkin Blade",
            "The Rogue Assassin",
            "The Emperor of the Sands",
            "The Shadow Reaper",
            "The Curator of the Sands",
            "The Artisan of War",
            "The Butcher of the Sands",
            "The Chain Warden",
            "The Unforgiven",
            "The Unforgotten"};
    private final int[] profilePictures = {
            R.mipmap.aatrox,
            R.mipmap.akali,
            R.mipmap.azir,
            R.mipmap.kayn,
            R.mipmap.nasus,
            R.mipmap.pantheon,
            R.mipmap.renekton,
            R.mipmap.thresh,
            R.mipmap.yasuo,
            R.mipmap.yone,};
}
