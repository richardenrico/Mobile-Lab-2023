package com.example.intentassignment;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;

import com.example.intentassignment.databinding.ActivityNewPostBinding;
import com.example.intentassignment.models.Post;
import com.example.intentassignment.models.Users;

public class NewPost_Activity extends AppCompatActivity {
    public static final String EXTRA_USERS = "extra_users";
    private @NonNull ActivityNewPostBinding binding;
    Users user;
    Post post;
    Uri uri;

    private final ActivityResultLauncher<Intent> launcherIntentPhotos = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(), result -> {
                if (result.getResultCode() == RESULT_OK){
                    Intent resultIntent = result.getData();
                    if (resultIntent != null) {
                        uri = resultIntent.getData();
                        binding.postPhoto.setImageURI(uri);
                    }
                }
            }
    );

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivityNewPostBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());

        post = new Post();

        user = getIntent().getParcelableExtra(EXTRA_USERS);

        binding.postPhoto.setOnClickListener(view -> {
            Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            launcherIntentPhotos.launch(Intent.createChooser(intent, "Choose a photo..."));
        });

        binding.btnUpload.setOnClickListener(v -> {
            post.setCaption(binding.caption.getText().toString());
            post.setPostPhoto(uri);
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            intent.putExtra(MainActivity.EXTRA_POST, post);
            intent.putExtra(MainActivity.EXTRA_USERS, user);
            startActivity(intent);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && data != null){
            uri = data.getData();
            binding.postPhoto.setImageURI(uri);
        }
   }
}