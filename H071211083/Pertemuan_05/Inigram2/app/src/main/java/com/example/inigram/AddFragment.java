package com.example.inigram;

import static android.app.Activity.RESULT_OK;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

public class AddFragment extends Fragment {

    ImageView addPost;
    EditText caption;
    Button btnupload;
    String ImageUri;

    ActivityResultLauncher<Intent> ImagePicker;
    static ArrayList<PostModel> posts = new ArrayList<>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ImagePicker = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
            if (result.getData() != null && result.getResultCode() == RESULT_OK){

                Uri uri = result.getData().getData();
                ImageUri = uri.toString();
                addPost.setImageURI(uri);

            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        addPost = view.findViewById(R.id.image);
        caption = view.findViewById(R.id.caption);
        btnupload = view.findViewById(R.id.btn_upload);

        addPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                ImagePicker.launch(Intent.createChooser(intent, "Select Image"));
            }
        });

        btnupload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String cpt = caption.getText().toString();
                Bundle bundle = new Bundle();
                posts.add(new PostModel(cpt, Uri.parse(ImageUri)));
                DataSource.addPost(new PostModel(cpt, Uri.parse(ImageUri)));
                bundle.putParcelableArrayList("Post", posts);

                HomeFragment homefragment = new HomeFragment();
                homefragment.setArguments(bundle);

                FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, homefragment).commit();
            }
        });

    }
}