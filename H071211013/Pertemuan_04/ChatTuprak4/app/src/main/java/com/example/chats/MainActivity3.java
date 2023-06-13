package com.example.chats;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity3 extends AppCompatActivity {
    ImageView back;
    CircleImageView profile;
    TextView nama, nomor,status, tgl;
    Chats c1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        profile = findViewById(R.id.iv_profil);
        nama = findViewById(R.id.tv_name);
        nomor = findViewById(R.id.tv_number);
        status = findViewById(R.id.tv_status);
        tgl = findViewById(R.id.tv_tanggal);

        c1 = getIntent().getParcelableExtra("user");
        profile.setOnClickListener(view -> {
            Intent pict = new Intent(this, img_detail.class);
            pict.putExtra("user",c1);
            startActivity(pict);
        });

        nama.setText(c1.getNama());
        nomor.setText(c1.getNumber());
        status.setText(c1.getStatus());
        tgl.setText(c1.getTgl_stat());
        profile.setImageResource(c1.getImg());
    }
    public void back (View view){
        finish();
    }

}