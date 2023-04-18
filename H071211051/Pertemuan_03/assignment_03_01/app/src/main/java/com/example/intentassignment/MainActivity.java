package com.example.intentassignment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

import com.example.intentassignment.databinding.ActivityMainBinding;
import com.example.intentassignment.models.Post;
import com.example.intentassignment.models.Users;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_POST = "extra_post";
    public static final String EXTRA_USERS = "extra_users";
    private @NonNull ActivityMainBinding binding;
    Users user;
    Post post;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());
        post = getIntent().getParcelableExtra(EXTRA_POST);
        user = getIntent().getParcelableExtra(EXTRA_USERS);


        binding.fullName.setText(user.getFullName());
        binding.username.setText(user.getUserName());
        binding.caption.setText(post.getCaption());
        binding.profilePhoto.setImageURI(user.getProfile());
        binding.postImage.setImageURI(post.getPostPhoto());
        binding.usernameCapt.setText(user.getUserName());
    }
}