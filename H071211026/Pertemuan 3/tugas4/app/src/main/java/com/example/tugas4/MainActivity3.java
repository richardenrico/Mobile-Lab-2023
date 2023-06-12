package com.example.tugas4;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;

import com.example.tugas4.databinding.ActivityMain3Binding;

public class MainActivity3 extends AppCompatActivity {

    private ActivityMain3Binding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMain3Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.imageFinal.setImageURI(getIntent().getParcelableExtra("image"));
        binding.imagePostFinal.setImageURI(getIntent().getParcelableExtra("imagePost"));
        binding.fullnameFinal.setText(getIntent().getStringExtra("fullname"));
        binding.usernameFinal.setText(getIntent().getStringExtra("username"));
        binding.usernameFinal2.setText(getIntent().getStringExtra("username"));
        binding.textCaptionFinal.setText(getIntent().getStringExtra("caption"));
    }
}