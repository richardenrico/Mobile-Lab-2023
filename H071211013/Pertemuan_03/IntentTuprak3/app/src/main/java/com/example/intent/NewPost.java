package com.example.intent;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class NewPost extends AppCompatActivity {
    private EditText caption;
    private Button up;
    private ImageView photo;
    User user;
    ActivityResultLauncher<Intent> imgLaunch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_post);

        caption = findViewById(R.id.capt);
        up = findViewById(R.id.upload);
        photo = findViewById(R.id.foto);

        user = getIntent().getParcelableExtra("user");

        imgLaunch = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                        Uri uri = result.getData().getData();
                        user.setFotouri(uri.toString());
                        try {
                            Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
                            photo.setImageBitmap(bitmap);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
        photo.setOnClickListener(view -> onBtnSelectImageClicked());

        up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                user.setCapt(caption.getText().toString());

                Intent result = new Intent(NewPost.this, PostResult.class);
                result.putExtra("user", user);
                startActivity(result);

                if (TextUtils.isEmpty((CharSequence) user.getFotouri())) {
                    Toast.makeText(NewPost.this, "Please Input a Picture", Toast.LENGTH_SHORT).show();
                    return;
                }
            }
        });
    }

    private void onBtnSelectImageClicked() {
        Intent pindah = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        pindah.setType("image/*");
        imgLaunch.launch(Intent.createChooser(pindah, "Silakan Pilih Picture"));
    }
}