package com.example.TP_Mobile_6_Ke_2;

public class Chat2 {
    public static  int MY_LAYOUT = 1;
    public static  int THEIR_LAYOUT = 2;


    private String pesan;
    private final int viewType;

    public Chat2(String pesan, int viewType) {
        this.pesan = pesan;
        this.viewType = viewType;
    }

    public String getPesan() {
        return pesan;
    }

    public int getViewType() {
        return viewType;
    }
}
