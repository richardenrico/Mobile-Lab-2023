package com.h071211059.pertemuan_03_02;

import android.content.Intent;
import android.content.res.AssetManager;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.h071211059.pertemuan_03_02.databinding.ActivityMenuBinding;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MenuActivity extends AppCompatActivity {
    public static final String EXTRA_USER = "extraUser";

    private ActivityMenuBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMenuBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        User user = getIntent().getParcelableExtra(EXTRA_USER);

        binding.tvUsername.setText(user.getUsername());
        binding.tvBestScore.setText(getString(R.string.best_score, user.getBestScore()));
        setImage(binding.ivImage, user.getImageUri());

        binding.btnPlay.setOnClickListener(v -> {
            Intent intent = new Intent(MenuActivity.this, QuizActivity.class);
            intent.putExtra("questions", getQuestions());
            intent.putExtra(MenuActivity.EXTRA_USER, user);
            startActivity(intent);
        });
    }

    private Question[] getQuestions() {
        AssetManager assetManager = getAssets();
        String jsonString;
        try {
            InputStream inputStream = assetManager.open("clubs.json");
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
            }
            jsonString = stringBuilder.toString();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(jsonString, JsonObject.class);
        JsonArray jsonArray = jsonObject.getAsJsonArray("data");

        return gson.fromJson(jsonArray, Question[].class);
    }

    private void setImage(ShapeableImageView ivImage, Uri imageUri) {
        if (imageUri != null) {
            ivImage.setImageURI(imageUri);
        } else {
            ivImage.setImageResource(R.drawable.ic_account);
        }
        ivImage.setPadding(0, 0, 0, 0);
    }
}
