package com.example.tugas4;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Toast;
import com.example.tugas4.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityResultLauncher<Intent> profilePict ;
    private ActivityMainBinding binding;

    private Uri profileUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setListener();

        profilePict = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
            if (result.getResultCode() == RESULT_OK) {
                Intent data = result.getData();
                assert data != null;
                profileUrl = data.getData();
                binding.image.setImageURI(profileUrl);
            }
        });
    }

    private void setListener(){
        binding.image.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            profilePict.launch(intent);
//            Toast.makeText(this, "pilih foto", Toast.LENGTH_SHORT).show();
        });

        binding.submit.setOnClickListener(v -> {
            String fullname = binding.fullname.getText().toString();
            String username = binding.username.getText().toString();



            if(profileUrl != null && !fullname.isEmpty() && !username.isEmpty()){
                Intent intent = new Intent(this, MainActivity2.class);
                intent.putExtra("fullname", fullname);
                intent.putExtra("username", username);
                intent.putExtra("image", profileUrl);
                startActivity(intent);
            }
        });

    }


}