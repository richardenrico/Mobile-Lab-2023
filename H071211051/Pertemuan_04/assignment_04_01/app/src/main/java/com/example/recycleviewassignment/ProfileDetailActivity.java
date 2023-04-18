package com.example.recycleviewassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import de.hdodenhof.circleimageview.CircleImageView;

public class ProfileDetailActivity extends AppCompatActivity {

    public static final String EXTRA_CHAT = "extra_chat";
    private CircleImageView iv_profile;
    private TextView tv_name;
    private TextView tv_status;
    private TextView tv_status_date;
    private ImageView btn_back;
    Data data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_detail);

        Data data = getIntent().getParcelableExtra(EXTRA_CHAT);

        iv_profile = findViewById(R.id.iv_profile);
        tv_name = findViewById(R.id.tv_name);
        tv_status = findViewById(R.id.tv_status);
        tv_status_date = findViewById(R.id.tv_status_date);
        btn_back = findViewById(R.id.btn_back);

        Glide.with(this).load(data.getPhoto_profile()).apply(new RequestOptions().override(350, 350)).into(iv_profile);
        tv_name.setText(data.getName());
        tv_status.setText(data.getStatus());
        tv_status_date.setText(data.getStatus_date());
        btn_back.setOnClickListener(view -> {finish();});

        iv_profile.setOnClickListener(view -> {
            Intent intent = new Intent(this, ImageDetailActivity.class);
            intent.putExtra(EXTRA_CHAT, data);
            startActivity(intent);
        });

    }
}