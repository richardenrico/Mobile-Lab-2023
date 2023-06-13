package com.example.chats;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity2 extends AppCompatActivity {
    private RecyclerView rvBubble;
    ImageView img;
    CircleImageView profile;
    CardView nav;
    TextView nama;
    Chats c1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        rvBubble = findViewById(R.id.rv_detail_chat);
        img = findViewById(R.id.iv_back);
        profile = findViewById(R.id.iv_profil);
        nav = findViewById(R.id.cv_profile);
        nama = findViewById(R.id.tv_name);

        rvBubble.setHasFixedSize(true);
        rvBubble.setLayoutManager(new LinearLayoutManager(this));

        c1 = getIntent().getParcelableExtra("user");
        setUpAdapter();
        
        nav.setOnClickListener(view -> {
            Intent sent = new Intent(this,MainActivity3.class);
            sent.putExtra("user",c1);
            startActivity(sent);
        });

        profile.setOnClickListener(view -> {
            Intent pict = new Intent(this, img_detail.class);
            pict.putExtra("user",c1);
            startActivity(pict);
        });

        nama.setText(c1.getNama());
        profile.setImageResource(c1.getImg());
    }


    public void back(View view){
        finish();
    }

    private void setUpAdapter() {
        DetailChatAdapter adapter = new DetailChatAdapter(DataDummy.detailChats());
        rvBubble.setAdapter(adapter);
    }
}
