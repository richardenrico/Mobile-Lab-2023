package com.h071211059.recyclerviewapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;

import com.h071211059.recyclerviewapp.databinding.ActivityProfileBinding;

public class ProfileActivity extends AppCompatActivity {
    private ActivityProfileBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProfileBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        User user = (User) getIntent().getParcelableExtra(MessageActivity.EXTRA_CHAT);
        Status status = getIntent().getParcelableExtra("status");

        setListener(user);
        setProfileInfo(user, status);
    }

    private void setListener(User user) {
        binding.topNavbar.ivBack.setOnClickListener(v -> finish());
        binding.ivProfile.setOnClickListener(v -> viewPhoto(user));
    }

    private void setProfileInfo(User user, Status status) {
        binding.tvNameProfile.setText(user.getName());
        binding.tvPhoneNumber.setText(user.getPhoneNumber());
        binding.ivProfile.setImageResource(user.getImage());
        binding.tvStatusTime.setText(status.getStatusTime());
        binding.tvStatusText.setText(status.getStatusText());
    }

    private void viewPhoto(User user) {
        Intent intent = new Intent(this, PhotoActivity.class);
        intent.putExtra(MessageActivity.EXTRA_CHAT, user);
        startActivity(intent);
    }
}