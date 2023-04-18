package com.h071211059.recyclerviewapp;

import java.util.ArrayList;
import java.util.Collections;

public class UserDataSource {
    public static ArrayList<User> chats = generateChat();

    private static ArrayList<User> generateChat() {
        ArrayList<User> chats = new ArrayList<>();
        chats.add(new User("Lucas Oliveira da Silva", MessageDataSource.messages, R.drawable.u1, "123456789", new Status("Olá, tudo bem?", "12:00")));
        chats.add(new User("Joaquín García Pérez", MessageDataSource.messages, R.drawable.u33, "123456789", new Status("Olá, tudo bem?", "12:00")));
        chats.add(new User("Valentina", MessageDataSource.messages, R.drawable.u42, "123456789", new Status("Olá, tudo bem?", "12:00")));
        chats.add(new User("Santiago", MessageDataSource.messages, R.drawable.u43, "123456789", new Status("Olá, tudo bem?", "12:00")));
        chats.add(new User("Mateo", MessageDataSource.messages, R.drawable.u44, "123456789", new Status("Olá, tudo bem?", "12:00")));

        chats.add(new User("Maximilian", MessageDataSource.messages, R.drawable.eu2, "123456789", new Status("Olá, tudo bem?", "12:00")));
        chats.add(new User("Lukas", MessageDataSource.messages, R.drawable.eu3, "123456789", new Status("Olá, tudo bem?", "12:00")));
        chats.add(new User("Alexander", MessageDataSource.messages, R.drawable.eu26, "123456789", new Status("Olá, tudo bem?", "12:00")));
        chats.add(new User("Felix", MessageDataSource.messages, R.drawable.eu1, "123456789", new Status("Olá, tudo bem?", "12:00")));
        chats.add(new User("Sebastian", MessageDataSource.messages, R.drawable.eu101, "123456789", new Status("Olá, tudo bem?", "12:00")));
        Collections.shuffle(chats);

        return chats;
    }
}
