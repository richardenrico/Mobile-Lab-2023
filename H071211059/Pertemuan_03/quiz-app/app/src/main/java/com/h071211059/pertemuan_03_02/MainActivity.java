package com.h071211059.pertemuan_03_02;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import com.h071211059.pertemuan_03_02.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private ActivityResultLauncher<Intent> imagePickLauncher;
    private Uri imageUrl;
    private String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        imagePickLauncher =
                registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                        result -> {
                            if (result.getResultCode() == -1) {
                                Intent data = result.getData();
                                assert data != null;
                                imageUrl = data.getData();
                                binding.ivImage.setImageURI(imageUrl);

                                binding.ivImage.requestLayout();
                                binding.ivImage.setContentPadding(0, 0, 0, 0);
                            }
                        });


        binding.ivImage.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_PICK,
                    MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            imagePickLauncher.launch(intent);

        });

        binding.btnStart.setOnClickListener(v -> {
            username = String.valueOf(binding.etUsername.getText());
            User user = new User(username, imageUrl, 0);

            Intent intent = new Intent(MainActivity.this, MenuActivity.class);
            intent.putExtra(MenuActivity.EXTRA_USER, user);

            if (!user.getUsername().isEmpty()) {
                startActivity(intent);
            } else {
                Toast.makeText(MainActivity.this, "Input your username", Toast.LENGTH_SHORT).show();
            }
        });

    }
}