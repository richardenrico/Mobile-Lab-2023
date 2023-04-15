package com.example.TP_Mobile_6_Ke_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.tp_mobile_6_ke_2.R;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity2 extends AppCompatActivity {

    RecyclerView recyclerView;
    chatAdapter2 chatAdapter2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        CircleImageView iv_profile = findViewById(R.id.iv_profilepicture);
        TextView tv_name = findViewById(R.id.tv_roomchat_name);
        RelativeLayout ib_profile = findViewById(R.id.ib_profile);

        int picture = getIntent().getIntExtra("Img",0);
        String name = getIntent().getStringExtra("Name");

        Glide.with(MainActivity2.this)
                        .load(picture)
                        .into(iv_profile);
        tv_name.setText(name);

        recyclerView = findViewById(R.id.rv_chatRoom);
        ArrayList<Chat2> list = new ArrayList<Chat2>();

        list.add(new Chat2("I am like a demon, but more edgy, right",Chat2.THEIR_LAYOUT));
        list.add(new Chat2("I can smile, and murder while I smile",Chat2.MY_LAYOUT));
        list.add(new Chat2("I will hack and chop and cleave, and sunder the filth of your forms!",Chat2.THEIR_LAYOUT));
        list.add(new Chat2("You would fight me?! Come, let me show you hell!",Chat2.MY_LAYOUT));

        chatAdapter2 = new chatAdapter2(list, MainActivity2.this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(chatAdapter2);
        chatAdapter2.notifyDataSetChanged();

        ib_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int picture = getIntent().getIntExtra("Img",0);
                String name = getIntent().getStringExtra("Name");
                String number = getIntent().getStringExtra("Number");
                String status = getIntent().getStringExtra("Status");
                String status_date = getIntent().getStringExtra("Status_Date");
                Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
                intent.putExtra("Img", picture);
                intent.putExtra("Name",name);
                intent.putExtra("Number",number);
                intent.putExtra("Status",status);
                intent.putExtra("Status_Date",status_date);
                startActivity(intent);
            }
        });
    }
}