package com.h071211059.pertemuan_06.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.h071211059.pertemuan_06.model.Post;
import com.h071211059.pertemuan_06.R;
import com.h071211059.pertemuan_06.databinding.FragmentAddPostBinding;

import java.util.ArrayList;

public class AddPostFragment extends Fragment {
    private FragmentAddPostBinding binding;
    private ActivityResultLauncher<Intent> imagePickLauncher;
    private Uri imageUri;
    private ArrayList<Post> posts;

    private static AddPostFragment instance;

    private AddPostFragment() {};

    public static AddPostFragment getInstance() {
        if (instance == null) {
            instance = new AddPostFragment();
        }
        return instance;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentAddPostBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView tvTitle = getActivity().findViewById(R.id.tv_title);
        tvTitle.setText("Add Post");

        imagePickLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == getActivity().RESULT_OK) {
                        Intent data = result.getData();
                        assert data != null;
                        imageUri = data.getData();
                        binding.ivPostImage.setImageURI(data.getData());
                    }
                });

        binding.ivPostImage.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            imagePickLauncher.launch(intent);
        });

        binding.btnUpload.setOnClickListener(v -> {
            if (imageUri != null) {
                String caption = String.valueOf(binding.etPostCaption.getText());
                Post newPost;
                if (caption.length() > 0) {
                    newPost = new Post(caption, imageUri);
                } else {
                    newPost = new Post(imageUri);
                }

                FragmentManager fragmentManager = getParentFragmentManager();
                HomeFragment fragment = HomeFragment.getInstance();

                Bundle bundle = new Bundle();
                bundle.putParcelable(HomeFragment.EXTRA_POST, newPost);
                fragment.setArguments(bundle);

                fragmentManager
                        .beginTransaction()
                        .replace(R.id.fl_container, fragment, HomeFragment.class.getSimpleName())
                        .commit();
            } else {
                Toast.makeText(getActivity(), "Please pick a photo first", Toast.LENGTH_SHORT).show();
            }
        });

    }
}