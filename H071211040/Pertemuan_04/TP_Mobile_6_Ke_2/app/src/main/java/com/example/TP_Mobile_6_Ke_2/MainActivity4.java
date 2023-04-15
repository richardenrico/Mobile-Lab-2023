package com.example.TP_Mobile_6_Ke_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.tp_mobile_6_ke_2.R;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        CircleImageView iv_profilePicture = findViewById(R.id.iv_profile4);
        TextView tv_name = findViewById(R.id.tv_roomchat_name);

        int picture = getIntent().getIntExtra("Img",0);
        String name = getIntent().getStringExtra("Name");

        tv_name.setText(name);
        Glide.with(MainActivity4.this)
                .load(picture)
                .into(iv_profilePicture);
    }
}