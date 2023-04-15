package com.example.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

public class PostResult extends AppCompatActivity {
    private TextView caption, nama, username;
    private ImageView photo;
    private CircleImageView pictprof;
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_result);

        caption = findViewById(R.id.capt);
        nama = findViewById(R.id.name);
        username = findViewById(R.id.username);
        photo = findViewById(R.id.foto);
        pictprof = findViewById(R.id.image);

        user = getIntent().getParcelableExtra("user");

        nama.setText(user.name);
        username.setText(user.username);
        caption.setText(user.capt);

        photo.setImageURI(Uri.parse(user.getFotouri()));
        pictprof.setImageURI(Uri.parse(user.getImageuri()));
    }
}