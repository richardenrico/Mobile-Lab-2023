package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.quizapp.databinding.ActivityResultBinding;
import com.example.quizapp.models.Players;

public class ResultActivity extends AppCompatActivity {
    private ActivityResultBinding binding;
    public static final String EXTRA_SCORE = "extra_score";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityResultBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        int score = getIntent().getIntExtra(EXTRA_SCORE, 0);
        Players players = getIntent().getParcelableExtra(MainActivity.EXTRA_PLAYERS);

        binding.score.setText(String.valueOf(score));


        if (score > players.getBestScore()) {
            players.setBestScore(score);
            binding.newBestScore.setText(String.valueOf(score));
        } else {
            binding.newBestScore.setText(String.valueOf(players.getBestScore()));
        }

        binding.btnBacktoHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ApplyActivity.class);
                intent.putExtra(MainActivity.EXTRA_PLAYERS, players);
                startActivity(intent);
            }
        });
    }
}