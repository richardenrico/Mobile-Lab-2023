package com.example.chats;

import androidx.appcompat.view.menu.MenuBuilder;

import java.util.ArrayList;

public class DataDummy {
    public static ArrayList<DetailChat> detailChats() {
        ArrayList<DetailChat> user = new ArrayList<>();

        user.add(new DetailChat("Lorem ipsum dolor sit amet, consectetur adipiscing elit","05.40"));
        user.add(new DetailChat("Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat","06.04"));
        user.add(new DetailChat("Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua", "06.04"));
        user.add(new DetailChat("Lorem ipsum dolor sit amet, consectetur adipiscing elit","06.05"));
        user.add(new DetailChat("Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat","06.17"));
        user.add(new DetailChat("Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua", "06.36"));
        user.add(new DetailChat("Lorem ipsum dolor sit amet, consectetur adipiscing elit","06.37"));
        user.add(new DetailChat("Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat","07.15"));
        user.add(new DetailChat("Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua", "07.38"));
        user.add(new DetailChat("Lorem ipsum dolor sit amet, consectetur adipiscing elit","07.40"));
        user.add(new DetailChat("Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua", "07.40"));
        user.add(new DetailChat("Lorem ipsum dolor sit amet, consectetur adipiscing elit","07.50"));
        user.add(new DetailChat("Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat","07.51"));

        return user;

    }
}
