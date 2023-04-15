package com.example.quizapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import de.hdodenhof.circleimageview.CircleImageView;

public class ActivityFirst extends AppCompatActivity {

    TextInputEditText edName;

    CircleImageView uImage;
    Button aButton;
    private static final int RESULT_IMG = 1;

    Uri selectedImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        edName = (TextInputEditText) findViewById(R.id.inputNameEdit);
        uImage = (CircleImageView) findViewById(R.id.profile_image);
        aButton = (Button) findViewById(R.id.BApply);

        aButton.setOnClickListener(view -> {
            if (TextUtils.isEmpty(edName.getText().toString()) && uImage.getDrawable().getConstantState() == getResources().getDrawable(R.drawable.ic_launcher_background).getConstantState()){
                Toast.makeText(this, "Upload image first", Toast.LENGTH_SHORT).show();
                edName.setError("Required");

            } else if (TextUtils.isEmpty(edName.getText().toString())) {
                edName.setError("Required");
            } else if (uImage.getDrawable().getConstantState() == getResources().getDrawable(R.drawable.ic_launcher_background).getConstantState()) {
                Toast.makeText(this, "Upload image first", Toast.LENGTH_SHORT).show();

            }else {
                Intent KeScnd = new Intent(getApplicationContext(), ActivityScnd.class);
                String name = edName.getText().toString();
                KeScnd.putExtra("Fname" , name);
                KeScnd.putExtra("image" ,selectedImage);
                startActivity(KeScnd);
            }
        });

        uImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent uplImage = new Intent(Intent.ACTION_PICK);
                uplImage.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(uplImage,RESULT_IMG);

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RESULT_IMG && resultCode == RESULT_OK){

            selectedImage = data.getData();
            uImage.setImageURI(selectedImage);
        }
    }
}
