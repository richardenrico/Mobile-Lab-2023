package com.h071211059.pertemuan_03_02;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.h071211059.pertemuan_03_02.databinding.ActivityScoreBinding;

public class ScoreActivity extends AppCompatActivity {
    public static final String EXTRA_SCORE = "score";
    private ActivityScoreBinding binding;
    private User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityScoreBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        user = getIntent().getParcelableExtra(MenuActivity.EXTRA_USER);

        showScore();
        binding.btnStartAgain.setOnClickListener(v -> {
            Intent intent = new Intent(ScoreActivity.this, MenuActivity.class);
            intent.putExtra(MenuActivity.EXTRA_USER, user);
            startActivity(intent);
            finish();
        });
    }

    private void showScore() {
        int bestScore = user.getBestScore();
        int score = getIntent().getIntExtra(EXTRA_SCORE, 0);

        binding.tvScore.setText(String.valueOf(score));

        if (bestScore < score) {
            binding.tvBestScore.setText(String.valueOf(score));
            user.setBestScore(score);
        } else {
            binding.tvBestScore.setText(String.valueOf(bestScore));
        }
    }
}