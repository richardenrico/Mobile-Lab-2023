package com.example.chats;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvChats;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvChats = findViewById(R.id.rvchats);
        rvChats.setHasFixedSize(true);
        rvChats.setLayoutManager(new LinearLayoutManager(this));

        setUpAdapter();
    }

    private void setUpAdapter() {
        ChatAdapter chatadapter = new ChatAdapter(ChatDataSource.getListUser());
        rvChats.setAdapter(chatadapter);
    }
}