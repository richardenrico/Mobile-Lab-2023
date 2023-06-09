package com.h071211059.recyclerviewapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.h071211059.recyclerviewapp.databinding.ActivityMessageBinding;

public class MessageActivity extends AppCompatActivity {
    public static final String EXTRA_CHAT = "chat";

    private ActivityMessageBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMessageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        User user = (User) getIntent().getParcelableExtra(EXTRA_CHAT);
        Status status = getIntent().getParcelableExtra("status");
        setTopNavbar(user);
        setMessageRv();

        binding.topNavbar.getRoot().setOnClickListener(v -> {
            toProfileActivity(user, status);
        });
    }

    private void toProfileActivity(User user, Status status) {
        Intent intent = new Intent(this, ProfileActivity.class);
        intent.putExtra(MessageActivity.EXTRA_CHAT, user);
        intent.putExtra("status", status);
        startActivity(intent);
    }

    private void setMessageRv() {
        binding.rvMessages.setLayoutManager(new LinearLayoutManager(this));
        MessageAdapter adapter = new MessageAdapter(MessageDataSource.messages);
        binding.rvMessages.setAdapter(adapter);
    }

   private void setTopNavbar(User chat) {
        binding.topNavbar.tvName.setText(chat.getName());
        binding.topNavbar.ivProfile.setImageResource(chat.getImage());
        binding.topNavbar.ivBack.setOnClickListener(v -> finish());
    }
}