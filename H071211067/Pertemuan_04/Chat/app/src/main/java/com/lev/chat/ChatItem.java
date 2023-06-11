package com.lev.chat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class ChatItem extends AppCompatActivity {

    private ImageView ivFoto;
    private TextView tvNama, tvTime;
    private ImageView btnBack;
    private RecyclerView rvListBubble;
    ModelChat modelChat;
    private ArrayList<ModelBubble> data = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.item_chat);
        btnBack = findViewById(R.id.btnBack);
        ivFoto = findViewById(R.id.iv_foto);
        tvNama = findViewById(R.id.tv_nama);
        rvListBubble = findViewById(R.id.rv_chat);
        Intent terima = getIntent();
        modelChat = terima.getParcelableExtra("chats");
        tvNama.setText(modelChat.getNama());

        Glide.with(ChatItem.this)
                .load(modelChat.getFoto())
                .into(ivFoto);

        btnBack.setOnClickListener(view -> finish());

        rvListBubble.setHasFixedSize(true);

        data.addAll(modelChat.getChat());
        tampilDataCard();
    }

    private void tampilDataCard() {
        rvListBubble.setLayoutManager(new LinearLayoutManager(this));
        AdapterBubble colokanChat = new AdapterBubble(data);
        rvListBubble.setAdapter(colokanChat);
    }

    public void openProfile(View view){
        Intent intent = new Intent(this, ProfileActivity.class);
        intent.putExtra("nama", modelChat.getNama());
        intent.putExtra("foto", modelChat.getFoto());
        intent.putExtra("status", modelChat.getStatus());
        intent.putExtra("nohp", modelChat.getNoHP());
        intent.putExtra("time", modelChat.getTime());
        startActivity(intent);
    }
}
