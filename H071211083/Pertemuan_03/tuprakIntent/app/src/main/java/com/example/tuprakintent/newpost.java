package com.example.tuprakintent;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Toast;

import com.example.tuprakintent.databinding.ActivityNewpostBinding;

import java.io.IOException;

public class newpost extends AppCompatActivity {
    private ActivityNewpostBinding binding;

    ActivityResultLauncher<Intent> imageSelectLauncher;
    private Bitmap image;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityNewpostBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        imageSelectLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
            if (result.getResultCode() == RESULT_OK || result.getData() != null) {
                Intent intent = result.getData();
                Uri uri = intent.getData();

                try {
                    image = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
                    binding.image.setImageBitmap(image);
                } catch (IOException ioException) {
                    throw new RuntimeException(ioException);
                }
            }
        });

        binding.image.setOnClickListener(view -> {
            Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            intent.setType("image/*");
            imageSelectLauncher.launch(intent);
        });

        binding.btnupload.setOnClickListener(view -> {
            Intent intent = new Intent(this, post.class);
            User.newpost.photo = image;
            User.newpost.deskripsi = binding.caption.getText().toString();

            if (User.newpost.deskripsi.isEmpty() || User.newpost.photo == null) {
                if (User.newpost.deskripsi.isEmpty()) {
                    binding.caption.setError("tidak boleh kosong");
                }
                if (User.newpost.photo == null) {
                    Toast.makeText(this, "masukan foto dulu! ", Toast.LENGTH_SHORT).show();
                }
                return;
            }
            startActivity(intent);
        });
    }
}