package com.example.quiz;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
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
import android.widget.TextView;
import android.widget.Toast;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity {
    CircleImageView img;
    EditText editname;
    TextView name, best;
    Button send, main;
    User user;
    ActivityResultLauncher<Intent> imageCaptureLauncher;
    ActivityResultLauncher<Intent> resultLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img = findViewById(R.id.image);
        editname = findViewById(R.id.edit_name);
        name = findViewById(R.id.nama);
        best = findViewById(R.id.sc_best);
        send = findViewById(R.id.apply);
        main = findViewById(R.id.play);
        user = new User();

        resultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if(result.getResultCode() == RESULT_OK){
                        assert result.getData() != null;
                        user = result.getData().getParcelableExtra("user");
                        best.setText("Best Score: " + String.valueOf(user.getBscore()));
                        user.setBscore(user.getBscore());

                        main.setText("Play Again!");
                }
        });

        imageCaptureLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                        Uri uri = result.getData().getData();
                        user.setImgUri(uri.toString());
                        try {
                            Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
                           img.setImageBitmap(bitmap);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });

        img.setOnClickListener(view -> onBtnSelectImageClicked());

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                user.setNama(String.valueOf(editname.getText()));

                if (TextUtils.isEmpty(editname.getText().toString())){
                    editname.setError("Please fill in your name!");
//                    Toast.makeText(MainActivity.this, "Please fill in your name", Toast.LENGTH_SHORT).show();
                } else {
                    editname.setVisibility(View.GONE);
                    name.setVisibility(View.VISIBLE);
                    name.setText(user.getNama());
                    best.setVisibility(View.VISIBLE);
                    send.setVisibility(View.GONE);
                    main.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    private void onBtnSelectImageClicked() {
        Intent pindah = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        pindah.setType("image/*");
        imageCaptureLauncher.launch(Intent.createChooser(pindah, "Silakan Pilih Profile Picture"));
    }

    public void play(View view) {
        Intent toQuiz = new Intent(MainActivity.this, Question.class);
        toQuiz.putExtra("user", user);
        resultLauncher.launch(toQuiz);
    }
}