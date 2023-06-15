package com.example.recyclerviewtask;

public class ModelClass {

    private int imageV;
    private String username;
    private String time1;
    private  String chat;

    public ModelClass(int imageV, String username, String time1, String chat) {
        this.imageV = imageV;
        this.username = username;
        this.time1 = time1;
        this.chat = chat;
    }

    public int getImageV() {
        return imageV;
    }

    public String getUsername() {
        return username;
    }

    public String getTime1() {
        return time1;
    }

    public String getChat() {
        return chat;
    }
}
