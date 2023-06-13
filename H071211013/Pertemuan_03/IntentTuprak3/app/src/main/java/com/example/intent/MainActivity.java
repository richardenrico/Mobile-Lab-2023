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
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity {
    private EditText nama, username;
    private Button kirim;
    private CircleImageView pictprof;
    User user;
    ActivityResultLauncher<Intent> imgLaunch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nama = findViewById(R.id.name);
        username = findViewById(R.id.username);
        kirim = findViewById(R.id.submit);
        pictprof = findViewById(R.id.image);

        user = new User();

        imgLaunch = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                        Uri uri = result.getData().getData();
                        user.setImageuri(uri.toString());
                        try {
                            Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
                            pictprof.setImageBitmap(bitmap);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
        pictprof.setOnClickListener(view -> onBtnSelectImageClicked());

        kirim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                user.setName(String.valueOf(nama.getText()));
                user.setUsername(String.valueOf(username.getText()));

                if (TextUtils.isEmpty((CharSequence) user.getUsername())) {
                    Toast.makeText(MainActivity.this, "Please Enter your Username", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty((CharSequence) user.getName())) {
                    Toast.makeText(MainActivity.this, "Please Enter your Name", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty((CharSequence) user.getImageuri())) {
                    Toast.makeText(MainActivity.this, "Please Input Your Profile Picture", Toast.LENGTH_SHORT).show();
                    return;
                }

                Intent submit = new Intent(MainActivity.this, NewPost.class);
                submit.putExtra("user", user);
                startActivity(submit);
            }
        });
    }

    private void onBtnSelectImageClicked() {
        Intent pindah = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        pindah.setType("image/*");
        imgLaunch.launch(Intent.createChooser(pindah, "Silakan Pilih Profile Picture"));
    }
}