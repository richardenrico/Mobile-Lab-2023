package com.example.quizapp;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;

import com.example.quizapp.databinding.ActivityApplyBinding;
import com.example.quizapp.models.Players;


public class ApplyActivity extends AppCompatActivity {
    private ActivityApplyBinding binding;
    Uri uri;
    Players player;
    private final ActivityResultLauncher<Intent> launcherIntentPhotos = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(), result -> {
                if (result.getResultCode() == RESULT_OK){
                    Intent resultIntent = result.getData();
                    if (resultIntent != null) {
                        uri = resultIntent.getData();
                        binding.profileImage.setImageURI(uri);
                    }
                }
            }
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivityApplyBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());

//        player = new Players();

        if (getIntent().getParcelableExtra(MainActivity.EXTRA_PLAYERS) != null) {
            player = getIntent().getParcelableExtra(MainActivity.EXTRA_PLAYERS);
            binding.name.setVisibility(VISIBLE);
            binding.inputName.setVisibility(GONE);
            binding.score.setVisibility(VISIBLE);
            binding.btnApply.setVisibility(GONE);
            binding.btnPlay.setVisibility(VISIBLE);

            binding.name.setText(player.getName());
            binding.score.setText("Best score : " + player.getBestScore());
        } else {
            player = new Players();
        }

        binding.btnApply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (binding.editName.getText().toString() == null) {
                    binding.editName.setError("Masukkan nama!");
                } else {
                    binding.name.setVisibility(VISIBLE);
                    binding.inputName.setVisibility(GONE);
                    binding.score.setVisibility(VISIBLE);
                    binding.btnApply.setVisibility(GONE);
                    binding.btnPlay.setVisibility(VISIBLE);

                    player.setName(binding.editName.getText().toString());

                    binding.name.setText(player.getName());
                    binding.score.setText("Best score : " + player.getBestScore());
                }
            }

        });
        binding.btnPlay.setOnClickListener(v -> {
            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra(MainActivity.EXTRA_PLAYERS, player);
            startActivity(intent);
        });

        binding.profileImage.setOnClickListener(view -> {
            Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            launcherIntentPhotos.launch(Intent.createChooser(intent, "Choose a photo..."));
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && data != null){
            uri = data.getData();
            binding.profileImage.setImageURI(uri);
        }
    }
}