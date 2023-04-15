package com.example.recyclerviewtask;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class chatBox extends AppCompatActivity {

    CircleImageView profile;
    TextView user;
    ImageButton view1;
    RecyclerView recyclerView;
    chatAdapter chatAdapter;
    ArrayList<ChatClass> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_box);

        profile = findViewById(R.id.profPics);
        user = findViewById(R.id.userr);
        view1 = findViewById(R.id.view);

        int pic = getIntent().getIntExtra("gambar", 0);
        String namaU = getIntent().getStringExtra("nama");
        String msg = getIntent().getStringExtra("chat");

        profile.setImageResource(pic);
        user.setText(namaU);

        recyclerView = findViewById(R.id.rv_parent);
        list = new ArrayList<>();

        list.add(new ChatClass("p", ChatClass.LAYOUT_ONE));
        list.add(new ChatClass("oi", ChatClass.LAYOUT_TWO));
        list.add(new ChatClass("Adkh", ChatClass.LAYOUT_ONE));
        list.add(new ChatClass("apatuh", ChatClass.LAYOUT_TWO));
        list.add(new ChatClass("Mabar", ChatClass.LAYOUT_ONE));
        list.add(new ChatClass("Gasskan", ChatClass.LAYOUT_TWO));
        list.add(new ChatClass(msg, ChatClass.LAYOUT_TWO));

        chatAdapter = new chatAdapter(list,chatBox.this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(chatAdapter);
        chatAdapter.notifyDataSetChanged();


        view1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int pic = getIntent().getIntExtra("gambar", 0);
                String namaU = getIntent().getStringExtra("nama");
                Intent intent = new Intent(chatBox.this, chatProfile.class);
                intent.putExtra("gambar1", pic);
                intent.putExtra("nama1", namaU);
                startActivity(intent);
            }
        });
    }
}