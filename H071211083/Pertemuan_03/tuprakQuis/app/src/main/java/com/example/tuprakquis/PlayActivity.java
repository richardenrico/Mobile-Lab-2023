package com.example.tuprakquis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;

import com.example.tuprakquis.databinding.ActivityPlayBinding;

public class PlayActivity extends AppCompatActivity {

    private ActivityPlayBinding binding;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPlayBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        user = getIntent().getParcelableExtra(ScoreActivity.EXTRA_USER);

        binding.name.setText(user.getName());
        binding.image.setImageURI(user.getProfile());

        binding.newbest.setText(String.valueOf(user.getBestScore()));

        binding.btnplay.setOnClickListener(view -> {
            Intent intent = new Intent(this, SoalActivity.class);
            intent.putExtra(ScoreActivity.EXTRA_USER, user);
            startActivity(intent);
        });
    }
}