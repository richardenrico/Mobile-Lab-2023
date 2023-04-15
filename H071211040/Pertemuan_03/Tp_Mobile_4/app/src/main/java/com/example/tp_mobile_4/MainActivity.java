package com.example.tp_mobile_4;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.time.Instant;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity {

    private static final int RESULT_IMGUPL = 1;
    CircleImageView upImage;

    Button submitBtn;
    EditText et_fullname, et_name;

    Uri selectedImage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        upImage = findViewById(R.id.imageButton1);

        submitBtn = findViewById(R.id.submit_btn);
        et_fullname = findViewById(R.id.fullname);
        et_name = findViewById(R.id.name);


        submitBtn.setOnClickListener(view -> {
            if (TextUtils.isEmpty(et_fullname.getText().toString()) && TextUtils.isEmpty(et_name.getText().toString()) &&
                    upImage.getDrawable().getConstantState() == getResources().getDrawable(R.drawable.fp1).getConstantState()){
                Toast.makeText(this, "Upload Image", Toast.LENGTH_SHORT).show();
                et_fullname.setError("Tidak Boleh Kosong");
                et_name.setError("Tidak Boleh Kosong");
            }else if (TextUtils.isEmpty(et_fullname.getText().toString()) && TextUtils.isEmpty(et_name.getText().toString())){
                et_fullname.setError("Tidak Boleh Kosong");
                et_name.setError("Tidak Boleh Kosong");
            } else if (upImage.getDrawable().getConstantState() == getResources().getDrawable(R.drawable.fp1).getConstantState() &&
                TextUtils.isEmpty(et_fullname.getText().toString())){
                Toast.makeText(this, "Upload Image", Toast.LENGTH_SHORT).show();
                et_fullname.setError("Tidak Boleh Kosong");
            } else if (upImage.getDrawable().getConstantState() == getResources().getDrawable(R.drawable.fp1).getConstantState() &&
                    TextUtils.isEmpty(et_name.getText().toString())){
                Toast.makeText(this, "Upload Image", Toast.LENGTH_SHORT).show();
                et_name.setError("Tidak Boleh Kosong");
            }else if (upImage.getDrawable().getConstantState() == getResources().getDrawable(R.drawable.fp1).getConstantState()) {
                Toast.makeText(this, "Upload Image", Toast.LENGTH_SHORT).show();
            }else if (TextUtils.isEmpty(et_fullname.getText().toString())) {
                et_fullname.setError("Tidak Boleh Kosong");
            }else if (TextUtils.isEmpty(et_name.getText().toString())) {
                et_name.setError("Tidak Boleh Kosong");
            }else{
                String fullname = et_fullname.getText().toString();
                String name = et_name.getText().toString();
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("Fullname",fullname);
                intent.putExtra("Name",name);
                intent.putExtra("Image", selectedImage);
                startActivity(intent);
            }
        });


        upImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent upIMG = new Intent(Intent.ACTION_PICK);
                upIMG.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(upIMG,RESULT_IMGUPL);

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RESULT_IMGUPL && resultCode == RESULT_OK) {

            selectedImage = data.getData();
            upImage.setImageURI(selectedImage);
        }
    }
}