package com.example.recycleviewassignment;


import java.util.ArrayList;

public class ChatData {
    public static ArrayList<DetailChat> detailChats = generateDummyData();

    private static ArrayList<DetailChat> generateDummyData() {
        ArrayList<DetailChat> chats = new ArrayList<>();

        chats.add(new DetailChat("you know what i'm thingking see it in you eyes?", "21:18", true ));
        chats.add(new DetailChat("you hate that you want me", "21:18", false ));
        chats.add(new DetailChat("hate it when you cry", "21:19", true ));
        chats.add(new DetailChat("you scared to be lonely, 'specially in the night", "21:19", false ));
        chats.add(new DetailChat("i'm scared that i'll miss you, happens every time", "21:19", true ));
        chats.add(new DetailChat("i don't want this feelin', i can't afford love", "21:19", false ));
        chats.add(new DetailChat("i try to find a reason to pull us apart", "21:20", true ));
        chats.add(new DetailChat("it ain't workin', cause you're perfect", "21:20", false ));
        chats.add(new DetailChat("and i know that you're worth it", "21:21", true ));
        chats.add(new DetailChat("i can't walk away", "21:21", false ));
        chats.add(new DetailChat("even though we're going through it", "21:21", true ));
        chats.add(new DetailChat("and it makes you feel alone", "21:22", false ));
        chats.add(new DetailChat("just know that i would die for you", "21:22", true ));
        chats.add(new DetailChat("baby, i would die for you", "21:23", false ));
        chats.add(new DetailChat("the distance and the time between us, it'll never change my mind", "21:23", true));
        chats.add(new DetailChat("cause baby, i would die for you", "21:23", false ));
        return chats;
    }
}
