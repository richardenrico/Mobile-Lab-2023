package com.example.tp_mobile_5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity4 extends AppCompatActivity {

    TextView tv_score,tv_name,tv_bestScore;
    Button btn_back_to_home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        btn_back_to_home = findViewById(R.id.btn_back_to_home);
        tv_score = findViewById(R.id.tv_score);
        tv_name = findViewById(R.id.tv_name);
        tv_bestScore = findViewById(R.id.tv_bestScore);

        String name = getIntent().getExtras().getString("Name");
        String Stats = getIntent().getStringExtra("status");
        int Score = getIntent().getIntExtra("Score",0);
        int bestScore = getIntent().getIntExtra("best_score",0);

        tv_name.setText(name + " " + Stats);
        tv_score.setText(String.valueOf(Score));
        tv_bestScore.setText(String.valueOf(bestScore));

        btn_back_to_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri selectedImage1 = getIntent().getParcelableExtra("Image");
                String name = getIntent().getExtras().getString("Name");
                int bestScore = getIntent().getIntExtra("best_score",0);
                Intent toBasic = new Intent(getApplicationContext(), MainActivity3.class);
                    toBasic.putExtra("Image", selectedImage1);
                    toBasic.putExtra("Name", name);
                    toBasic.putExtra("best_score", bestScore);
                startActivity(toBasic);
            }
        });
    }
}