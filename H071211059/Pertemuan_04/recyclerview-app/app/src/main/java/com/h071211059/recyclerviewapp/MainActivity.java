package com.h071211059.recyclerviewapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.h071211059.recyclerviewapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
//        System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAA");

        setChatRv();


    }
    private void setChatRv() {
        binding.rvChat.setLayoutManager(new LinearLayoutManager(this));
        binding.rvChat.addItemDecoration(new DividerItemDecoration(this,
                DividerItemDecoration.VERTICAL));
        UserAdapter adapter = new UserAdapter(UserDataSource.chats);
        adapter.setClickListener(this::goToMessage, this::viewPhoto);
        binding.rvChat.setAdapter(adapter);
    }

    private void viewPhoto(User user) {
        Intent intent = new Intent(this, PhotoActivity.class);
        intent.putExtra(MessageActivity.EXTRA_CHAT, user);
        startActivity(intent);
    }

    private void goToMessage(User user) {
        Intent intent = new Intent(MainActivity.this, MessageActivity.class);
        intent.putExtra(MessageActivity.EXTRA_CHAT, user);
        intent.putExtra("status", user.getStatus());
        startActivity(intent);
        System.out.println(user.getStatus().getStatusText());
    }


}