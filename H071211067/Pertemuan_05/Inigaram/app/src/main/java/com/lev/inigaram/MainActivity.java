package com.lev.inigaram;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public ArrayList<ItemModel> listdata = new ArrayList<>();
    private HomeFragment homeFragment;
    private UploadFragment uploadFragment;
    private ProfileFragment profileFragment;
    ImageButton btnHome, btnAddPost, btnProfil;
    TextView tvToolbar;
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnHome = findViewById(R.id.btn_home);
        btnAddPost = findViewById(R.id.btn_add);
        btnProfil = findViewById(R.id.btn_profil);
        tvToolbar = findViewById(R.id.tv_toolbar);

        homeFragment = new HomeFragment();
        uploadFragment = new UploadFragment();
        profileFragment = new ProfileFragment();

        fragmentManager = getSupportFragmentManager();

        Fragment fragment = fragmentManager.findFragmentByTag(HomeFragment.class.getSimpleName());

        if (!(fragment instanceof HomeFragment)) {
            fragmentManager
                    .beginTransaction()
                    .add(R.id.frame_container, homeFragment, HomeFragment.class.getSimpleName())
                    .commit();
        }

        btnHome.setOnClickListener(v -> navigateFragment(homeFragment));
        btnAddPost.setOnClickListener(v -> navigateFragment(uploadFragment));
        btnProfil.setOnClickListener(v -> navigateFragment(profileFragment));
    }

    public void navigateFragment(Fragment fragment) {
        fragmentManager
                .beginTransaction()
                .replace(R.id.frame_container, fragment)
                .addToBackStack(null)
                .commit();
    }
}
