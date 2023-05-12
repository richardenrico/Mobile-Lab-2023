package com.example.tuprakintent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.tuprakintent.databinding.ActivityPostBinding;

public class post extends AppCompatActivity {
    private ActivityPostBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPostBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.image.setImageBitmap(User.Foto);
        binding.namaatas.setText(User.Username);
        binding.namabawah.setText(User.FUll_name);

        binding.imgupload.setImageBitmap(User.newpost.photo);
        binding.caption2.setText(User.newpost.deskripsi);
    }
}