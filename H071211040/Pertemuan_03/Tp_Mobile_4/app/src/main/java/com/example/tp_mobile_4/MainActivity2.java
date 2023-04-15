package com.example.tp_mobile_4;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    private static final int RESULT_IMGUPL = 1;
    Button btn_upload;
    EditText et_caption;

    private String fullnama, nama;

    Uri selectedImage1;
    Uri selectedImage2;
    private final int GALLERY_REQ_CODE = 1000;

    private ImageView upImage2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        upImage2 = findViewById(R.id.imageButton3);

        btn_upload = findViewById(R.id.uploadbtn);

        et_caption = findViewById(R.id.caption);

        fullnama = getIntent().getExtras().getString("Fullname");
        nama = getIntent().getExtras().getString("Name");
        selectedImage1 = getIntent().getParcelableExtra("Image");
        selectedImage2 = getIntent().getParcelableExtra("Image2");

        btn_upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (upImage2.getDrawable().getConstantState() == getResources().getDrawable(R.drawable.gallery_logo).getConstantState() &&
                        TextUtils.isEmpty(et_caption.getText().toString())) {
                    Toast.makeText(MainActivity2.this, "Upload Image", Toast.LENGTH_SHORT).show();
                    et_caption.setError("Tidak Boleh Kosong");
                } else if (upImage2.getDrawable().getConstantState() == getResources().getDrawable(R.drawable.gallery_logo).getConstantState()) {
                    Toast.makeText(MainActivity2.this, "Upload Image", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(et_caption.getText().toString())) {
                    et_caption.setError("Tidak Boleh Kosong");
                } else {
                    String caption = et_caption.getText().toString();
                    Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
                    intent.putExtra("Fullname",fullnama);
                    intent.putExtra("Name",nama);
                    intent.putExtra("Caption",caption);
                    intent.putExtra("Image", selectedImage1);
                    intent.putExtra("Image2", selectedImage2);
                    startActivity(intent);
                }
            }
        });

        upImage2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent upIMG = new Intent(Intent.ACTION_PICK);
                upIMG.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                int RESULT_IMGUPL = 1;
                startActivityForResult(upIMG,RESULT_IMGUPL);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RESULT_IMGUPL && resultCode == RESULT_OK) {

            selectedImage2 = data.getData();
            upImage2.setImageURI(selectedImage2);
        }
    }
}