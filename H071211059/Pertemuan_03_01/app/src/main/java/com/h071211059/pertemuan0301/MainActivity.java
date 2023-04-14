package com.h071211059.pertemuan0301;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private ActivityResultLauncher<Intent> profilePickLauncher;
    private ImageView ivPhoto;
    private EditText etName, etUsername;
    private Button btnSubmit;
    private Uri profileUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ivPhoto = findViewById(R.id.iv_profile);
        etName = findViewById(R.id.et_fullname);
        etUsername = findViewById(R.id.et_username);

        profilePickLauncher =
                registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                        result -> {
            if (result.getResultCode() == RESULT_OK) {
                Intent data = result.getData();
                assert data != null;
//                        setProfileUrl(data.getData());
                profileUrl = data.getData();
                ivPhoto.setImageURI(profileUrl);
            }
        });

        ivPhoto.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_PICK,
                    MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            profilePickLauncher.launch(intent);
        });


        btnSubmit = findViewById(R.id.btn_submit);
        btnSubmit.setOnClickListener(v -> {
            if (profileUrl != null && checkInput()) {
                Intent intent = new Intent(this, NewPostActivity.class);

                intent.putExtra(PostActivity.EXTRA_NAME, etName.getText().toString());
                intent.putExtra(PostActivity.EXTRA_USERNAME, etUsername.getText().toString());
                intent.putExtra(PostActivity.EXTRA_PROFILE, profileUrl);

                startActivity(intent);
            } else {
                Toast.makeText(MainActivity.this, "Please pick a profile photo first",
                        Toast.LENGTH_LONG).show();
            }
        });

    }

    /**
     * Set the profile url
     * @param url the url of the profile photo
     */
    private void setProfileUrl(Uri url) {
        this.profileUrl = url;
    }

    /**
     * Check if all input is filled
     *
     * @return true if the input is valid, false otherwise
     */
    private boolean checkInput() {
        String name = etName.getText().toString();
        String username = etUsername.getText().toString();

        if (name.isEmpty() || username.isEmpty()) {
            if (name.isEmpty()) etName.setError("Field can't be empty");
            if (username.isEmpty()) etUsername.setError("Field can't be empty");
            return false;
        }

        return true;
    }
}