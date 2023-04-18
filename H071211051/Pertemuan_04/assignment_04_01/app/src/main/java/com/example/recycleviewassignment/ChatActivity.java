package com.example.recycleviewassignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.security.AccessController;

import de.hdodenhof.circleimageview.CircleImageView;

public class ChatActivity extends AppCompatActivity {

    public static final String EXTRA_CHAT = "extra_chat";
    private TextView tv_name;
    private CircleImageView iv_profile;
    private ImageView btn_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        Data chats = getIntent().getParcelableExtra(EXTRA_CHAT);
        RecyclerView rvChat = findViewById(R.id.rv_chat);
        rvChat.setHasFixedSize(true);
        rvChat.setLayoutManager(new LinearLayoutManager(this));

        tv_name = findViewById(R.id.tv_name);
        tv_name.setText(chats.getName());
        iv_profile = findViewById(R.id.iv_photo);
        Glide.with(this).load(chats.getPhoto_profile()).apply(new RequestOptions().override(350, 350)).into(iv_profile);
        btn_back = findViewById(R.id.btn_back);
        btn_back.setOnClickListener(view -> {
            finish();
        });
        tv_name.setOnClickListener(view -> {
            Intent intent = new Intent(this, ProfileDetailActivity.class);
            intent.putExtra(ProfileDetailActivity.EXTRA_CHAT, chats);
            startActivity(intent);
        });
        iv_profile.setOnClickListener(view -> {
            Intent intent = new Intent(this, ProfileDetailActivity.class);
            intent.putExtra(ProfileDetailActivity.EXTRA_CHAT, chats);
            startActivity(intent);
        });


        if (ChatData.detailChats.size() == 16){
            ChatData.detailChats.add(new DetailChat(chats.getMessage(), chats.getTime(), true));
        }else {
            ChatData.detailChats.remove(ChatData.detailChats.size()-1);
            ChatData.detailChats.add(new DetailChat(chats.getMessage(), chats.getTime(), true));
        }

        DetailChatAdapter adapter = new DetailChatAdapter(ChatData.detailChats);
        rvChat.setAdapter(adapter);



    }
}