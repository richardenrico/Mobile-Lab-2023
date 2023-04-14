package com.h071211059.pertemuan0301;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class PostActivity extends AppCompatActivity {
    final public static String EXTRA_IMAGE = "extra-image";
    final public static String EXTRA_CAPTION = "extra-caption";
    final public static String EXTRA_NAME = "extra-name";
    final public static String EXTRA_USERNAME = "extra-username";
    final public static String EXTRA_PROFILE = "extra-profile";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        ImageView ivImage = findViewById(R.id.iv_image);
        TextView tvName = findViewById(R.id.tv_fullname);
        TextView tvUsername = findViewById(R.id.tv_username);
        TextView tvCaption = findViewById(R.id.tv_caption);
        ImageView ivProfile = findViewById(R.id.iv_profile);

        tvName.setText(getIntent().getStringExtra(EXTRA_NAME));
        tvUsername.setText(getIntent().getStringExtra(EXTRA_USERNAME));
        tvCaption.setText(getIntent().getStringExtra(EXTRA_CAPTION));
        ivImage.setImageURI(getIntent().getParcelableExtra(PostActivity.EXTRA_IMAGE));
        ivProfile.setImageURI(getIntent().getParcelableExtra(PostActivity.EXTRA_PROFILE));
    }
}