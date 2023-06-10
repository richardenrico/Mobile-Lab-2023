
package com.example.tp_mobile_4;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity3 extends AppCompatActivity {

    TextView namapanjangji, namaji, captionji;
    ImageView fotoPost;
    CircleImageView fotoProfil;

    String datafullname,dataname, captionna;

    Uri fotoProfilna, fotoPostna;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        namapanjangji = findViewById(R.id.tvFullname);
        namaji = findViewById(R.id.tvName);
        captionji = findViewById(R.id.tvcaption);

        fotoProfil = findViewById(R.id.ivProfil);
        fotoPost = findViewById(R.id.fotopost);

        datafullname = getIntent().getStringExtra("Fullname");
        dataname = getIntent().getStringExtra("Name");
        captionna = getIntent().getStringExtra("Caption");
        fotoProfilna = getIntent().getParcelableExtra("Image");
        fotoPostna = getIntent().getParcelableExtra("Image2");

        namapanjangji.setText(datafullname);
        namaji.setText(dataname);
        captionji.setText(captionna);


        fotoProfil.setImageURI(fotoProfilna);
        fotoPost.setImageURI(fotoPostna);



    }
}