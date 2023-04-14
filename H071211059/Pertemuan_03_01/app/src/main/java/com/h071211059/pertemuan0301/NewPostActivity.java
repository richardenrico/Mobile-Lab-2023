package com.h071211059.pertemuan0301;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

public class NewPostActivity extends AppCompatActivity {

    private ActivityResultLauncher<Intent> imagePickLauncher;
    private ImageView ivImage;
    private Uri imageUrl;
    private EditText etCaption;

    private Button uploadBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_post);

        imagePickLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == RESULT_OK) {
                        Intent data = result.getData();
                        assert data != null;
                        setImageUrl(data.getData());
                        ivImage.setImageURI(data.getData());
                    }
                });


        ivImage = findViewById(R.id.iv_image);
        ivImage.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            imagePickLauncher.launch(intent);
        });

        etCaption = (EditText) findViewById(R.id.et_caption_make);

        uploadBtn = findViewById(R.id.btn_upload);
        uploadBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String caption = etCaption.getText().toString();
                String name = getIntent().getStringExtra(PostActivity.EXTRA_NAME);
                String username = getIntent().getStringExtra(PostActivity.EXTRA_USERNAME);
                Uri profileUrl = getIntent().getParcelableExtra(PostActivity.EXTRA_PROFILE);

                if (imageUrl != null) {
                    Intent intent = new Intent(NewPostActivity.this, PostActivity.class);
                    intent.putExtra(PostActivity.EXTRA_CAPTION, caption);
                    intent.putExtra(PostActivity.EXTRA_NAME, name);
                    intent.putExtra(PostActivity.EXTRA_USERNAME, username);
                    intent.putExtra(PostActivity.EXTRA_IMAGE, imageUrl);
                    intent.putExtra(PostActivity.EXTRA_PROFILE, profileUrl);
                    startActivity(intent);
                }
            }
        });
    }


    /**
     * update imageUrl
     */
    private void setImageUrl(Uri url) {
        imageUrl = url;
    }
}