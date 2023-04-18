package com.example.recycleviewassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class ImageDetailActivity extends AppCompatActivity {

    public static final String EXTRA_CHAT = "extra_chat";
    private TextView tv_name;
    private ImageView iv_photo;
    private ImageButton btn_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_detail);

        iv_photo = findViewById(R.id.iv_photo);
        tv_name = findViewById(R.id.tv_name);
        btn_back = findViewById(R.id.btn_back);

        Data data = getIntent().getParcelableExtra(EXTRA_CHAT);

        tv_name.setText(data.getName());
        Glide.with(ImageDetailActivity.this).load(data.getPhoto_profile()).apply(new RequestOptions().override(350, 350)).into(iv_photo);

        btn_back.setOnClickListener(view -> {
            finish();
        });

    }
}