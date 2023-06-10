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

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        CircleImageView iv_profilePicture = findViewById(R.id.iv_profilepicture);
        TextView tv_name = findViewById(R.id.tv_roomchat_name);
        TextView tv_number = findViewById(R.id.tv_number);
        TextView tv_status= findViewById(R.id.tv_status);
        TextView tv_status_date= findViewById(R.id.tv_Status_Date);

        int picture = getIntent().getIntExtra("Img",0);
        String name = getIntent().getStringExtra("Name");
        String number = getIntent().getStringExtra("Number");
        String status = getIntent().getStringExtra("Status");
        String status_date = getIntent().getStringExtra("Status_Date");

        Glide.with(MainActivity3.this)
                .load(picture)
                .into(iv_profilePicture);
        tv_name.setText(name);
        tv_number.setText(number);
        tv_status.setText(status);
        tv_status_date.setText(status_date);


        iv_profilePicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int picture = getIntent().getIntExtra("Img",0);
                String name = getIntent().getStringExtra("Name");
                Intent intent = new Intent(MainActivity3.this, MainActivity4.class);
                intent.putExtra("Img", picture);
                intent.putExtra("Name",name);
                startActivity(intent);
            }
        });
    }
}