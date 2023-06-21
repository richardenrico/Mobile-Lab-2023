package com.example.bgthreadassigment;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.bgthreadassigment.Models.PostModel;
import com.example.bgthreadassigment.Models.UserModel;
import com.google.android.material.textfield.TextInputEditText;

import java.io.IOException;
import java.util.ArrayList;

public class AddPostFragment extends Fragment {
    private ImageView addImagePostIv;
    private TextInputEditText addDescriptionEt;
    private Button postBtn;
    private Bitmap bitmap;
    private ActivityResultLauncher<Intent> mGetContent;
    private PostModel postModel;
    private UserModel userModel = new UserModel("kimgaram", "Kim Ga Ram", R.drawable.gara);

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mGetContent = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        Intent data = result.getData();
                        Uri postImage = data.getData();
                        try {
                            bitmap = MediaStore.Images.Media.getBitmap(requireActivity().getContentResolver(), postImage);
                            addImagePostIv.setImageBitmap(bitmap);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
        );
        return inflater.inflate(R.layout.fragment_add_post, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setView();

        addImagePostIv.setOnClickListener(v -> {
            Intent i = new Intent(Intent.ACTION_PICK,
                    MediaStore.Images.Media.INTERNAL_CONTENT_URI);
            mGetContent.launch(i);
        });

        postBtn.setOnClickListener(v -> {
            if (bitmap == null) {
                Toast.makeText(getContext(), "Select an Image", Toast.LENGTH_SHORT).show();
                return;
            }

            String postDescription = addDescriptionEt.getText().toString();

            postModel = new PostModel(userModel, bitmap, postDescription);

            bitmap = null;
            addImagePostIv.setImageBitmap(null);
            addDescriptionEt.setText("");

            Bundle bundle = new Bundle();
            bundle.putParcelable("postModel", postModel);

            HomeFragment homeFragment = new HomeFragment();
            homeFragment.setArguments(bundle);
            FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragmentContainer, homeFragment, HomeFragment.class.getSimpleName()).commit();
            Toast.makeText(getContext(), "Post Success", Toast.LENGTH_SHORT).show();
        });
    }

    private void setView() {
        addDescriptionEt = getView().findViewById(R.id.addDescriptionEt);
        addImagePostIv = getView().findViewById(R.id.addImagePostIv);
        postBtn = getView().findViewById(R.id.postBtn);
    }

}