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
import android.os.Bundle;
import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity3 extends AppCompatActivity {

    CircleImageView foto_profil;
    TextView tv_name, tv_bestScore;
    Button btn_play;

    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        foto_profil = findViewById(R.id.profileImage);
        tv_name = findViewById(R.id.ET_name1);
        tv_bestScore = findViewById(R.id.ET_BestScore);
        btn_play = findViewById(R.id.btn_play);

        String name = getIntent().getExtras().getString("Name");
        Uri selectedImage1 = getIntent().getParcelableExtra("Image");
        int bestScore = getIntent().getIntExtra("best_score", 0);

        foto_profil.setImageURI(selectedImage1);
        tv_name.setText(name);
        tv_bestScore.setText("Best Score : "+ bestScore);

        btn_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = getIntent().getExtras().getString("Name");
                Uri selectedImage1 = getIntent().getParcelableExtra("Image");
                int bestScore = getIntent().getIntExtra("best_score",0);
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra("Name", name);
                intent.putExtra("Image", selectedImage1);
                intent.putExtra("best_score", bestScore);
                startActivity(intent);
            }
        });
    }

    protected void onDestroy(){
        super.onDestroy();
        sharedPreferences = getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("best_score", 0);
        editor.apply();
    }
}