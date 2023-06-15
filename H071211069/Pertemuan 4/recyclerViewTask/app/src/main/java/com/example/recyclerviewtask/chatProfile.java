package com.example.recyclerviewtask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

public class chatProfile extends AppCompatActivity {

    CircleImageView profilePicture;
    TextView name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_profile);

        profilePicture = findViewById(R.id.profPic);
        name = findViewById(R.id.uProf);




        int picture = getIntent().getIntExtra("gambar1",0);
        String name1 = getIntent().getStringExtra("nama1");

        profilePicture.setImageResource(picture);
        name.setText(name1);




    }
}