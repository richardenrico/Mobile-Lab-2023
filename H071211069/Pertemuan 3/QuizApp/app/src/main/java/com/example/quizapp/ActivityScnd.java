package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

import de.hdodenhof.circleimageview.CircleImageView;

public class ActivityScnd extends AppCompatActivity {

    TextView edName1,bscore;

    CircleImageView uImage1;
    Button pButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scnd);

        edName1 = (TextView) findViewById(R.id.tUser);
        uImage1 = (CircleImageView) findViewById(R.id.profile_image1);
        pButton = (Button) findViewById(R.id.BPlay);
        bscore = findViewById(R.id.bscore1);

        String data1= getIntent().getStringExtra("Fname");
        Uri uri1 = (Uri) getIntent().getParcelableExtra("image");
        edName1.setText(data1);
        uImage1.setImageURI(uri1);
        int bestScore = getIntent().getIntExtra("best_score", 0);
        bscore.setText("Best score: " + bestScore);
        pButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String data1= getIntent().getStringExtra("Fname");
                Uri uri1 = (Uri) getIntent().getParcelableExtra("image");
                int bestScore = getIntent().getIntExtra("best_score", 0);
                Intent KeMain = new Intent(getApplicationContext(), MainActivity.class);
                KeMain.putExtra("Fname" , data1);
                KeMain.putExtra("best_score", bestScore);
                KeMain.putExtra("image" ,uri1);
                startActivity(KeMain);
            }
        });


    }

}