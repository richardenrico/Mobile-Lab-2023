package com.example.tuprakintent;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Instrumentation;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Toast;

import com.example.tuprakintent.databinding.ActivityMainBinding;

import java.io.IOException;


public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    ActivityResultLauncher<Intent> imageSelectLauncher;
    private Bitmap image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        imageSelectLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
            if (result.getResultCode() == RESULT_OK || result.getData() != null){
                Intent intent = result.getData();
                Uri uri = intent.getData();

                try {
                    image = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
                    binding.image.setImageBitmap(image);
                }catch (IOException ioException){
                    throw new RuntimeException(ioException);
                }
            }
        });

        binding.image.setOnClickListener(view -> {
            Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            intent.setType("image/*");
            imageSelectLauncher.launch(intent);
        });

        binding.btnsubmit.setOnClickListener(view -> {
            Intent intent = new Intent(this, newpost.class);
        User.FUll_name = binding.fullname.getText().toString();
        User.Username = binding.username.getText().toString();
        User.Foto = image;

        if (User.FUll_name.isEmpty() || User.Username.isEmpty() || User.Foto == null) {
            if (User.FUll_name.isEmpty()) {
                binding.fullname.setError("tidak boleh kosong");
            }
            if (User.Username.isEmpty()) {
                binding.username.setError("tidak boleh kosong");
            }
            if (User.Foto == null) {
                Toast.makeText(this, "masukan foto dulu!", Toast.LENGTH_SHORT).show();
            }
            return;
        }
            startActivity(intent);
        });
    }
}