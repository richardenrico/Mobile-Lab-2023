package com.lev.post;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class PostResultActivity extends AppCompatActivity {

    ImageView iv_profile, iv_post;
    TextView tv_username, tv_namalengkap, tv_caption;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_result);

        iv_profile = findViewById(R.id.iv_profile);
        iv_post = findViewById(R.id.iv_post);
        tv_username = findViewById(R.id.tv_username);
        tv_namalengkap = findViewById(R.id.tv_namalengkap);
        tv_caption = findViewById(R.id.tv_caption);

        intent = getIntent();
        Uri uri = (Uri) intent.getParcelableExtra("img");
        iv_profile.setImageURI(uri);

        String namalengkap = getIntent().getStringExtra("extranamalengkap");
        tv_namalengkap.setText(namalengkap);

        String username = getIntent().getStringExtra("extrausername");
        tv_username.setText(username);

        Uri post = (Uri) intent.getParcelableExtra("imgpost");
        iv_post.setImageURI(post);

        String caption = getIntent().getStringExtra("extracaption");
        tv_caption.setText(caption);
    }
}