package com.lev.quiz;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.lev.quiz.databinding.ActivityPlayBinding;

public class PlayActivity extends AppCompatActivity {

    private ActivityPlayBinding binding;
    User user;
    User dataUser;
    public final static String DATA_USER = "data user";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPlayBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        dataUser = getIntent().getParcelableExtra(DATA_USER);

        binding.tvScoreNumNow.setText(String.valueOf(dataUser.score));
        if (dataUser.score > dataUser.bestScore) {
            dataUser.bestScore = dataUser.score;
        }
        binding.tvBestScoreNum.setText(String.valueOf(dataUser.bestScore));
        binding.tvDesc.setText("GGWP " + dataUser.name + "!!");
        binding.btnHome.setOnClickListener(view -> {
            Intent intent = new Intent(this, ProfileActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            intent.putExtra(ProfileActivity.DATA_USER, dataUser);
            startActivity(intent);
        });
    }
}