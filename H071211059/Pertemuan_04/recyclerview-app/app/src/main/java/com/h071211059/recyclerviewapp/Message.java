package com.h071211059.recyclerviewapp;

public class Message {
    private String msgText;
    private String msgTime;
    private boolean isSentByMe;

    public String getMsgText() {
        return msgText;
    }

    public void setMsgText(String msgText) {
        this.msgText = msgText;
    }

    public String getMsgTime() {
        return msgTime;
    }

    public void setMsgTime(String msgTime) {
        this.msgTime = msgTime;
    }

    public boolean isSentByMe() {
        return isSentByMe;
    }

    public void setSentByMe(boolean sentByMe) {
        isSentByMe = sentByMe;
    }

    public Message(String msgText, String msgTime, boolean isSentByMe) {
        this.msgText = msgText;
        this.msgTime = msgTime;
        this.isSentByMe = isSentByMe;
    }
}
