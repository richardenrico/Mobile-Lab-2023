package com.lev.post;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class PostActivity extends AppCompatActivity {

    ImageView iv_post;
    EditText et_caption;
    Button btn_upload;
    Intent intent;
    Uri post;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        iv_post = findViewById(R.id.iv_post);
        et_caption = findViewById(R.id.et_caption);
        btn_upload = findViewById(R.id.btn_upload);

        intent = getIntent();
        Uri uri = (Uri) intent.getParcelableExtra("img");
        String namalengkap = getIntent().getStringExtra("extranamalengkap");
        String username = getIntent().getStringExtra("extrausername");

        iv_post.setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_GET_CONTENT);
            intent.setType("image/*");
            startActivityForResult(intent, 1);
        });

        btn_upload.setOnClickListener(v -> {
            if (et_caption.getText().length()<10 && post==null) {
                Toast.makeText(getApplicationContext(), "Lengkapi data!", Toast.LENGTH_SHORT).show();
            } else if (et_caption.getText().length()<10){
                Toast.makeText(getApplicationContext(), "Caption minimal 10 karakter", Toast.LENGTH_SHORT).show();
            } else if (post==null) {
                Toast.makeText(getApplicationContext(), "Lengkapi foto postingan", Toast.LENGTH_SHORT).show();
            } else {
            String caption = et_caption.getText().toString();
            Intent intent = new Intent(this, PostResultActivity.class);
            intent.putExtra("imgpost", post);
            intent.putExtra("extracaption", caption);
            intent.putExtra("img", uri);
            intent.putExtra("extranamalengkap", namalengkap);
            intent.putExtra("extrausername", username);
            startActivity(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && data!=null) {
            post = data.getData();
            iv_post.setImageURI(post);
        }
    }
}