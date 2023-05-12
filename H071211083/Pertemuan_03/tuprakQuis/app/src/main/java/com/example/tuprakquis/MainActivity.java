package com.example.tuprakquis;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Toast;

import com.example.tuprakquis.databinding.ActivityMainBinding;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private User user;

    ActivityResultLauncher<Intent> imageSelectLauncher;
    private Bitmap image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        user = new User();

        imageSelectLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
            if (result.getResultCode() == RESULT_OK || result.getData() != null){
                Intent intent = result.getData();
                Uri uri = intent.getData();

                try {
                    image = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
                    user.setProfile(uri);
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

        binding.btnapllay.setOnClickListener(view -> {
            Intent intent = new Intent(this, PlayActivity.class);
            user.setName(binding.name.getText().toString());

            if (user.getName().isEmpty() || user.getProfile() == null) {
                if (user.getName().isEmpty()) {
                    binding.name.setError("tidak boleh kosong");
                }
                if (user.getProfile() == null) {
                    Toast.makeText(this, "masukan foto dulu!", Toast.LENGTH_SHORT).show();
                }
                return;
            }

            intent.putExtra(ScoreActivity.EXTRA_USER, user);
            startActivity(intent);
        });
    }
    @Override
    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);

        outState.clear();
    }
}