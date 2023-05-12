package com.example.tuprakquis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.tuprakquis.databinding.ActivityMainBinding;
import com.example.tuprakquis.databinding.ActivityScoreBinding;

public class ScoreActivity extends AppCompatActivity {

    private ActivityScoreBinding binding;
    public static final String EXTRA_USER = "extra_user";
    public static final String EXTRA_SCORE = "extra_score";
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityScoreBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        int score = getIntent().getIntExtra(EXTRA_SCORE, 0);
        user = getIntent().getParcelableExtra(EXTRA_USER);
        binding.score.setText(String.valueOf(score));
        if (score > user.getBestScore()){
            user.setBestScore(score);
            binding.bestScore.setText(String.valueOf(score));
        }else {
            binding.bestScore.setText(String.valueOf(user.getBestScore()));
        }

        binding.btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ScoreActivity.this, PlayActivity.class);
                intent.putExtra(EXTRA_USER, user);
                startActivity(intent);
            }
        });

    }
}