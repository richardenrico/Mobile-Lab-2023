package com.lev.quiz;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import com.lev.quiz.databinding.ActivityProfileBinding;

import java.io.IOException;

public class ProfileActivity extends AppCompatActivity {

    private ActivityProfileBinding binding;
    ActivityResultLauncher<Intent> imageSelectLauncher;
    private Bitmap image;
    User user;

    public final static String DATA_USER = "data user";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProfileBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        user = new User();

        imageSelectLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
            if (result.getResultCode() == RESULT_OK || result.getData() != null) {
                Intent intent = result.getData();
                Uri uri = intent.getData();

                try {
                    image = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
                    binding.ivPhoto.setImageBitmap(image);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        binding.ivPhoto.setOnClickListener(view -> {
            Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            intent.setType("image/*");
            imageSelectLauncher.launch(intent);
            binding.ivPhoto.setStrokeColor(ColorStateList.valueOf(Color.parseColor("#FFFFFFFF")));
        });

        binding.btnApply.setOnClickListener(view -> {
            if (user.name == null) {
                if (binding.etName.getText().toString().isEmpty()) {
                    binding.etName.setError("Silahkan diisi");
                    return;
                }
                binding.tvName.setVisibility(View.VISIBLE);
                binding.tvBestScore.setVisibility(View.VISIBLE);
                binding.etName.setVisibility(View.GONE);
                binding.btnApply.setText("Play");

                user.name = binding.etName.getText().toString();
                binding.tvName.setText(user.name);
            } else {
                Intent intent = new Intent(this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                intent.putExtra(MainActivity.DATA_USER, user);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        user = intent.getParcelableExtra(DATA_USER);
        if (user.score > user.bestScore) {
            user.bestScore = user.score;
        }
        binding.tvBestScore.setText("Best Score: " + user.bestScore);
    }
}