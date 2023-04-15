package com.example.chats;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class img_detail extends AppCompatActivity {
    ImageView back, profil;
    TextView name;
    Chats c1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_img_detail);

        back = findViewById(R.id.btn_back);
        name = findViewById(R.id.tv_name);
        profil = findViewById(R.id.iv_profil);

        c1 = getIntent().getParcelableExtra("user");
        name.setText(c1.getNama());
        profil.setImageResource(c1.getImg());

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }
}