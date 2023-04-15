package com.example.TP_Mobile_6_Ke_2;

import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

public class Chat {

    private int iv_profile;
    private String tv_name, tv_time, tv_chat, tv_nomor, tv_status, tv_tgl_status;

    public Chat(int iv_profile, String tv_name, String tv_time, String tv_chat,  String tv_nomor, String tv_status, String tv_tgl_status) {
        this.iv_profile = iv_profile;
        this.tv_name = tv_name;
        this.tv_time = tv_time;
        this.tv_chat = tv_chat;
        this.tv_nomor = tv_nomor;
        this.tv_status = tv_status;
        this.tv_tgl_status = tv_tgl_status;
    }

    public int getIv_profile() {
        return iv_profile;
    }

    public void setIv_profile(int iv_profile) {
        this.iv_profile = iv_profile;
    }

    public String getTv_name() {
        return tv_name;
    }

    public void setTv_name(String tv_name) {
        this.tv_name = tv_name;
    }

    public String getTv_time() {
        return tv_time;
    }

    public void setTv_time(String tv_time) {
        this.tv_time = tv_time;
    }

    public String getTv_chat() {
        return tv_chat;
    }

    public void setTv_chat(String tv_chat) {
        this.tv_chat = tv_chat;
    }

    public String getTv_nomor() {
        return tv_nomor;
    }

    public void setTv_nomor(String tv_nomor) {
        this.tv_nomor = tv_nomor;
    }

    public String getTv_status() {
        return tv_status;
    }

    public void setTv_status(String tv_status) {
        this.tv_status = tv_status;
    }

    public String getTv_tgl_status() {
        return tv_tgl_status;
    }

    public void setTv_tgl_status(String tv_tgl_status) {
        this.tv_tgl_status = tv_tgl_status;
    }

}
