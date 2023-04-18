package com.h071211059.recyclerviewapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.PorterDuff;
import android.os.Bundle;

import com.h071211059.recyclerviewapp.databinding.ActivityPhotoBinding;

public class PhotoActivity extends AppCompatActivity {
    private ActivityPhotoBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPhotoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        User user = getIntent().getParcelableExtra(MessageActivity.EXTRA_CHAT);
        binding.ivPhoto.setImageResource(user.getImage());
        binding.llTopNavbar.ivBack.setOnClickListener(v -> finish());
        binding.llTopNavbar.ivBack.setColorFilter(ContextCompat.getColor(this, R.color.white), PorterDuff.Mode.SRC_IN);
    }
}