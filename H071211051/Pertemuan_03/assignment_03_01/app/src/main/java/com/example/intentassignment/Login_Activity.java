package com.example.intentassignment;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.intentassignment.databinding.ActivityLoginBinding;
import com.example.intentassignment.models.Users;

public class Login_Activity extends AppCompatActivity {
    private ActivityLoginBinding binding;
    Uri uri;
    Users user;

    private final ActivityResultLauncher<Intent> launcherIntentPhotos = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(), result -> {
                if (result.getResultCode() == RESULT_OK){
                    Intent resultIntent = result.getData();
                    if (resultIntent != null) {
                        uri = resultIntent.getData();
                        binding.profile.setImageURI(uri);
                    }
                }
            }
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());

        user = new Users();

        binding.btnSubmit.setOnClickListener(view -> {
            user.setProfile(uri);
            if (uri == null) {
                Toast.makeText(this, "Masukkan gambar", Toast.LENGTH_SHORT).show();
                return;
            }
            user.setFullName(binding.fullName.getText().toString());
            if (binding.fullName.equals("")) {
                binding.fullName.setError("Harap isi!");
                return;
            }
            user.setUserName(binding.username.getText().toString());
            if (binding.username.equals("")) {
                binding.username.setError("Harap isi!");
                return;
            }

            Intent intent = new Intent(this, NewPost_Activity.class);
            intent.putExtra(NewPost_Activity.EXTRA_USERS, user);
            startActivity(intent);
        });

        binding.profile.setOnClickListener(view -> {
            Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            launcherIntentPhotos.launch(Intent.createChooser(intent, "Choose a photo..."));
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && data != null){
            uri = data.getData();
            binding.profile.setImageURI(uri);
        }
    }
}