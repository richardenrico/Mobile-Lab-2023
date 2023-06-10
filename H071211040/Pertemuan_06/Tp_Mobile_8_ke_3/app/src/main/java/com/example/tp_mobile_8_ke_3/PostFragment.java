package com.example.tp_mobile_8_ke_3;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class PostFragment extends Fragment {

    private RelativeLayout rlUpImageContainer;
    private ImageView iv_post_image;
    private EditText et_post_caption;
    private Button btn_upload;
    private UserModel userModel;

    private ActivityResultLauncher<Intent> launcherIntentImage = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == -1 && result.getData() != null){
                        Uri selectedPhoto = result.getData().getData();
                        iv_post_image.setImageURI(selectedPhoto);
                        Uri fileUri = result.getData().getData();
                        userModel.getPost().setImg_post(fileUri);


                    }

                }
            }
    );

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_post, container, false);
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

        rlUpImageContainer = view.findViewById(R.id.rlUpImageContainer);

        iv_post_image = view.findViewById(R.id.iv_post_image);
        et_post_caption = view.findViewById(R.id.et_post_caption);
        btn_upload = view.findViewById(R.id.btn_upload);

        userModel = new UserModel("Adam","Muchtar Adam",R.drawable.poro1, new PostModel());

        rlUpImageContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent("android.intent.action.PICK");
                intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
                launcherIntentImage.launch(intent);
            }
        });

        btn_upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((iv_post_image.getDrawable().getConstantState() == ResourcesCompat.getDrawable(getResources(), R.drawable.baseline_image_24, null).getConstantState())) {
                    Toast.makeText(getContext(), "Upload Image First", Toast.LENGTH_SHORT).show();
                } else {
                    String capt = et_post_caption.getText().toString();

                    userModel.getPost().setCaption(capt);

                    HomeFragment.dataSource.addUser(userModel);
                    HomeFragment homeFragment = new HomeFragment();
                    et_post_caption.setText("");
                    iv_post_image.setImageURI(null);

                    FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
                    transaction.replace(R.id.container, homeFragment);
                    transaction.commit();
                }
            }
        });
    }

}
