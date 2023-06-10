package com.example.tp_mobile_8_ke_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {
    ImageView civ_userProfile;
    TextView tv_name, tv_Username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        civ_userProfile = findViewById(R.id.civ_userProfile);
        tv_name = findViewById(R.id.tv_name);
        tv_Username = findViewById(R.id.tv_Username);

        Intent intent = getIntent();
        int image = intent.getIntExtra("pic", 0);
        String name = intent.getStringExtra("name");
        String username = intent.getStringExtra("username");

        civ_userProfile.setImageResource(image);
        tv_name.setText(name);
        tv_Username.setText(username);

    }
}