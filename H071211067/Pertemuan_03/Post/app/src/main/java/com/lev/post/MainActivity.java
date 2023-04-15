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

public class MainActivity extends AppCompatActivity {

    ImageView iv_profile;
    EditText et_namalengkap, et_username;
    Button btn_submit;
    Uri uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iv_profile = findViewById(R.id.iv_profile);
        et_namalengkap = findViewById(R.id.et_namalengkap);
        et_username = findViewById(R.id.et_username);
        btn_submit = findViewById(R.id.btn_submit);

        iv_profile.setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_GET_CONTENT);
            intent.setType("image/*");
            startActivityForResult(intent, 1);
        });

        btn_submit.setOnClickListener(v -> {
            if (et_namalengkap.getText().length()==0 && et_username.getText().length()==0 && uri==null) {
                Toast.makeText(getApplicationContext(), "Lengkapi data!", Toast.LENGTH_SHORT).show();
            } else if (et_namalengkap.getText().length()<12) {
                Toast.makeText(getApplicationContext(), "Nama lengkap minimal 12 karakter", Toast.LENGTH_SHORT).show();
            } else if (et_username.getText().length()<4) {
                Toast.makeText(getApplicationContext(), "Nama pengguna minimal 4 karakter", Toast.LENGTH_SHORT).show();
            } else if (uri==null) {
                Toast.makeText(getApplicationContext(), "Lengkapi foto profil", Toast.LENGTH_SHORT).show();
            }else {
                String namalengkap = et_namalengkap.getText().toString();
                String username = et_username.getText().toString();
                Intent intent = new Intent(this, PostActivity.class);
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
            uri = data.getData();
            iv_profile.setImageURI(uri);
        }
    }
}