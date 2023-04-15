package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class QuizResult extends AppCompatActivity {
    TextView name,poin,bestpoin;
    Button kembali;
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_result);

        name = findViewById(R.id.nama);
        poin = findViewById(R.id.sc);
        bestpoin = findViewById(R.id.sc_best);
        kembali = findViewById(R.id.back);

        user = getIntent().getParcelableExtra("user");
        name.setText(user.getNama());
        poin.setText(String.valueOf(user.getScore()));

        if (user.getScore() > user.getBscore()){
            user.setBscore(user.getScore());
            bestpoin.setText(String.valueOf(user.getScore()));
        } else {
            user.setScore(user.getScore());
            bestpoin.setText(String.valueOf(user.getBscore()));
        }

        kembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent back = new Intent();
                back.putExtra("user",user);
                setResult(RESULT_OK, back);
                finish();
            }
        });
    }
}