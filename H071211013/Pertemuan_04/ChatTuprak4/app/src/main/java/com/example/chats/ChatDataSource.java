package com.example.chats;

import java.util.ArrayList;

public class ChatDataSource {
    public static ArrayList<Chats> getListUser() {
        ArrayList<Chats> user = new ArrayList<>();

        user.add(new Chats("Wonho", "Losing me is better","20.05","+62 823-567-890","Active","6 Desember 2018", R.drawable.wonho));
        user.add(new Chats("Hermione", "It's sort of exciting isn't it?","19.10","+62 823-567-890","Active","6 Desember 2018", R.drawable.dog));
        user.add(new Chats("Hanni", "I was really hoping that he will come","18.30","+62 823-567-890","Active","6 Desember 2018", R.drawable.hanni));
        user.add(new Chats("Hwiyoung", "Trust me, okay?","15.10","+62 823-567-890","Active","6 Desember 2018", R.drawable.hwi));
        user.add(new Chats("Marv", "what ru doin'???","14.52","+62 823-567-890","Active","6 Desember 2018", R.drawable.prof));
        user.add(new Chats("Debora", "consider it as a warning","14.22","+62 823-567-890","Active","6 Desember 2018", R.drawable.p2));
        user.add(new Chats("Candy", "i just got up","14.22","+62 823-567-890","Active","6 Desember 2018", R.drawable.kucing));
        user.add(new Chats("Lilac", "take a good care!","13.40","+62 823-567-890","Active","6 Desember 2018", R.drawable.p1));
        user.add(new Chats("John", "wake uppppp!!!","13.02","+62 823-567-890","Active","6 Desember 2018", R.drawable.kucing1));
        user.add(new Chats("Joy", "Throw all the painful memories","12.50","+62 823-567-890","Active","6 Desember 2018", R.drawable.joy));
        user.add(new Chats("Wonho", "Losing me is better","12.35","+62 823-567-890","Active","6 Desember 2018", R.drawable.wonho));
        user.add(new Chats("Hwiyoung", "Trust me, okay?","12.10","+62 823-567-890","Active","6 Desember 2018", R.drawable.hwi));
        user.add(new Chats("Hermione", "It's sort of exciting isn't it?","11.56","+62 823-567-890","Active","6 Desember 2018", R.drawable.dog));
        user.add(new Chats("Candy", "i just got up","11.42","+62 823-567-890","Active","6 Desember 2018", R.drawable.p2));
        user.add(new Chats("Lilac", "take a good care!","11.20","+62 823-567-890","Active","6 Desember 2018", R.drawable.p1));
        user.add(new Chats("Marv", "what ru doin'???","11.05","+62 823-567-890","Active","6 Desember 2018", R.drawable.prof));

        return user;
    }
}
