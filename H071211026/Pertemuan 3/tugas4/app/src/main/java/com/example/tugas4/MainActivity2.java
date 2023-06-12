package com.example.tugas4;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;

import com.example.tugas4.databinding.ActivityMain2Binding;

public class MainActivity2 extends AppCompatActivity {

    private ActivityResultLauncher<Intent> postPict;

    protected ActivityMain2Binding binding;

    private Uri postUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMain2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setListeners();

        postPict = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
            if (result.getResultCode() == RESULT_OK) {
                Intent data = result.getData();
                assert data != null;
                postUrl = data.getData();
                binding.imagePost.setImageURI(postUrl);
            }
        });
    }


    private  void setListeners(){
        binding.imagePost.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            postPict.launch(intent);
        });

        binding.upload.setOnClickListener(v -> {
            String fullname = getIntent().getStringExtra("fullname");
            String username = getIntent().getStringExtra("username");
            Uri profilePict = getIntent().getParcelableExtra("image");
            String caption = binding.textCaption.getText().toString();

            if(postUrl != null && !caption.isEmpty()){
                Intent intent = new Intent(this, MainActivity3.class);
                intent.putExtra("fullname", fullname);
                intent.putExtra("username", username);
                intent.putExtra("image", profilePict);
                intent.putExtra("caption", caption);
                intent.putExtra("imagePost", postUrl);
                startActivity(intent);
            }
        });
    }
}