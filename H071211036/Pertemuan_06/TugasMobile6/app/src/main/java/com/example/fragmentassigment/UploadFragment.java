package com.example.fragmentassigment;

import static android.app.Activity.RESULT_OK;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

public class UploadFragment extends Fragment {
    private EditText etCaption;
    private ImageView ivUpload;
    private Button btnUpload;
    private String imageUri;
    private ArrayList<PostModel> dataList = new ArrayList();
    ActivityResultLauncher<Intent> launcher;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_upload, container, false);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        etCaption = view.findViewById(R.id.et_caption);
        ivUpload = view.findViewById(R.id.iv_upload);
        btnUpload = view.findViewById(R.id.btn_upload);

        launcher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(), result -> {
                    if (result.getResultCode() == RESULT_OK) {
                        Intent resultIntent = result.getData();

                        if (resultIntent != null) {
                            imageUri = String.valueOf(resultIntent.getData());
                            ivUpload.setImageURI(Uri.parse(imageUri));
                        }
                    }
                }
        );

        ivUpload.setOnClickListener(view1 -> {
            Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            launcher.launch(Intent.createChooser(gallery, "choose a picture!"));
        });

        btnUpload.setOnClickListener(view1 -> {
            String capt = etCaption.getText().toString();
            if (imageUri != null) {
                PostDataSource.dataList.add(new PostModel("Spider-Man", "Miles Morales", capt, "https://i.pinimg.com/564x/1f/4c/7a/1f4c7ab5d3a8ec275b3f1877b99f70f1.jpg", "https://i.pinimg.com/564x/6c/60/83/6c60839f63f4332382d789081d287da2.jpg", "", imageUri));

                imageUri = null;

                HomeFragment homeFragment = new HomeFragment();

                getParentFragmentManager().beginTransaction().replace(R.id.frameContainer, homeFragment).commit();
                Toast.makeText(getActivity(), "posted", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getContext(), "upload your image first", Toast.LENGTH_SHORT).show();
            }

            etCaption.getText().clear();
        });
    }
}