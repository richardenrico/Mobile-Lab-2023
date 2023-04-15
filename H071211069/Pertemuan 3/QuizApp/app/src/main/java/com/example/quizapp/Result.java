package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Result extends AppCompatActivity {
    TextView scre,stat,bscore;
    Button reset;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        scre = findViewById(R.id.score);
        stat = findViewById(R.id.status);
        reset = findViewById(R.id.Rbutton);
        bscore = findViewById(R.id.bscore);

        Intent keEnd = getIntent();
        int Score = keEnd.getIntExtra("Score",0);
        String Stats= getIntent().getStringExtra("status");
        int bestScore = getIntent().getIntExtra("best_score", 0);
        bscore.setText("Best score: " + bestScore);



        scre.setText(String.valueOf(Score));
        stat.setText(Stats);



        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int bestScore = getIntent().getIntExtra("best_score", 0);
                String data1= getIntent().getStringExtra("Fname");
                Uri uri1 = (Uri) getIntent().getParcelableExtra("image");
                Intent KeA = new Intent(getApplicationContext(), ActivityScnd.class);
                KeA.putExtra("best_score", bestScore);
                KeA.putExtra("Fname" , data1);
                KeA.putExtra("image" ,uri1);
                startActivity(KeA);
            }
        });

    }


}