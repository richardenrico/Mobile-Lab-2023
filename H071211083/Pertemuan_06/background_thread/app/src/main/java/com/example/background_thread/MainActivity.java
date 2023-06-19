package com.example.background_thread;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.background_thread.data.model.Post;
import com.example.background_thread.data.model.User;
import com.example.background_thread.home.HomeFragment;
import com.example.background_thread.profile.ProfileFragment;
import com.example.background_thread.search.SearchFragment;
import com.example.background_thread.upload.AddPostFragment;

public class MainActivity extends AppCompatActivity {

    private HomeFragment homeFragment;
    private AddPostFragment addPostFragment;
    private ProfileFragment profileFragment;
    private SearchFragment searchFragment;
    ImageView btnHome, btnAddPost, btnProfile, btnSearch;
    TextView judul;
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnHome = findViewById(R.id.Homee);
        btnAddPost = findViewById(R.id.tambah);
        btnProfile = findViewById(R.id.akun);
        btnSearch = findViewById(R.id.cari);
        judul = findViewById(R.id.judul);

        homeFragment = new HomeFragment();
        addPostFragment = new AddPostFragment();
        profileFragment = new ProfileFragment();
        searchFragment = new SearchFragment();

        fragmentManager = getSupportFragmentManager();

        Fragment fragment = fragmentManager.findFragmentByTag(HomeFragment.class.getSimpleName());

        if (!(fragment instanceof HomeFragment)) {
            fragmentManager
                    .beginTransaction()
                    .add(R.id.fragment_container, homeFragment, HomeFragment.class.getSimpleName())
                    .commit();
        }

        btnHome.setOnClickListener(v -> {
            Bundle bundle = getIntent().getExtras();
            homeFragment.setArguments(bundle);
            navigateFragment(homeFragment, "Inigaram");
        });
        btnAddPost.setOnClickListener(v -> navigateFragment(addPostFragment, "Upload"));

        btnProfile.setOnClickListener(v -> {
            profileFragment.setUser(new User("Liska_", "Liska Dewi Rombe", R.drawable.panda, new Post()));
            navigateFragment(profileFragment, "Profile");
        });

        btnSearch.setOnClickListener(v -> navigateFragment(searchFragment, "Search"));
    }

    public void navigateFragment(Fragment fragment, String text) {
        judul.setText(text);
        fragmentManager
                .beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit();
    }
}