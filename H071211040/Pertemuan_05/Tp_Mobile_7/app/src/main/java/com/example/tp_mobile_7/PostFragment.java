package com.example.tp_mobile_7;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class PostFragment extends Fragment {

    public static final String Key1 = "Capt";

    private static final int RESULT_IMGUPL = 1;

    RelativeLayout rl_UpImage;
    ImageView iv_uploadImage;
    Uri selectedImage;
    EditText et_caption;
    Button bttn_Upload;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_post, container, false);

        rl_UpImage = view.findViewById(R.id.rlUpImageContainer);
        iv_uploadImage = view.findViewById(R.id.ivButtonUploadImage);
        et_caption = view.findViewById(R.id.etCaption);
        bttn_Upload = view.findViewById(R.id.bttnUpload);



        bttn_Upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((iv_uploadImage.getDrawable().getConstantState() == ResourcesCompat.getDrawable(getResources(), R.drawable.baseline_image_24, null).getConstantState())) {
                    Toast.makeText(getContext(), "Upload Image First", Toast.LENGTH_SHORT).show();
                } else {
                    String capt = et_caption.getText().toString();
                    Bundle bundle = new Bundle();
                    bundle.putString(PostFragment.Key1, capt);

                    bundle.putParcelable("Image", selectedImage);

                    HomeFragment homeFragment = new HomeFragment();
                    homeFragment.setArguments(bundle);
                    getActivity().getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.flContainer, homeFragment, "HomeFragment")
                            .addToBackStack(null)
                            .commit();
                }
            }
        });

        rl_UpImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent upIMG = new Intent(Intent.ACTION_PICK);
                upIMG.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(upIMG, RESULT_IMGUPL);
            }
        });
        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RESULT_IMGUPL && resultCode == getActivity().RESULT_OK) {
            selectedImage = data.getData();
            iv_uploadImage.setImageURI(selectedImage);
        }
    }
}