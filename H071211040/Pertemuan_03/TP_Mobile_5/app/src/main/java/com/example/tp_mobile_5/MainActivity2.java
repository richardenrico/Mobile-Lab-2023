package com.example.tp_mobile_5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.Nullable;
import android.os.Bundle;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity2 extends AppCompatActivity {

    CircleImageView upImage;
    EditText name;
    Button bttn1;
    private static final int RESULT_IMGUPL = 1;
    Uri selectedImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        upImage = findViewById(R.id.ImgBtnUpload);
        name = findViewById(R.id.ET_name);
        bttn1 = findViewById(R.id.Bttn_Apply);

        bttn1.setOnClickListener(view -> {
            if (TextUtils.isEmpty(name.getText().toString()) && upImage.getDrawable().getConstantState() == getResources().getDrawable(R.drawable.pp).getConstantState()) {
                Toast.makeText(this, "Upload Image", Toast.LENGTH_SHORT).show();
                name.setError("Input Your Name");
            } else if (TextUtils.isEmpty(name.getText().toString())) {
                name.setError("Input Your Name");
            } else if (upImage.getDrawable().getConstantState() == getResources().getDrawable(R.drawable.pp).getConstantState()) {
                Toast.makeText(this, "Upload Image", Toast.LENGTH_SHORT).show();
            }else {
                String name1 = name.getText().toString();
                Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
                intent.putExtra("Name",name1);
                intent.putExtra("Image",selectedImage);
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