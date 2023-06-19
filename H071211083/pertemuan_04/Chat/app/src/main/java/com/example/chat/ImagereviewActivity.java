package com.example.chat;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ImagereviewActivity extends AppCompatActivity {

    private ImageView backButton;
    private TextView name;
    private ImageView profilePict;

    public static final String EXTRA_CHAT = "extra_chat" ;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imagereview);
        backButton = findViewById(R.id.backArrow);
        name = findViewById(R.id.namereview);
        profilePict = findViewById(R.id.pictreview);

        ModelClass modelClass = getIntent().getParcelableExtra(EXTRA_CHAT);
        profilePict.setImageResource(modelClass.getImageView1());
        name.setText(modelClass.getTextView1());

        backButton.setOnClickListener(view -> finish());
    }
}