package com.example.tp_mobile_7;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;


public class MainActivity extends AppCompatActivity {

    LinearLayout ll_NavigationBar;
    private FragmentManager fragmentManager;
    ImageView homeButton, postButton, profileButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ll_NavigationBar = findViewById(R.id.llNavigationBar);

        fragmentManager = getSupportFragmentManager();

        homeButton = findViewById(R.id.ivHomeButton);
        postButton = findViewById(R.id.ivPostButton);
        profileButton = findViewById(R.id.ivProfileButton);

        Fragment fragment = new HomeFragment();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.flContainer, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

        setClickListeners(homeButton, postButton, profileButton);
    }

    private void setClickListeners(ImageView homeButton, ImageView postButton, ImageView profileButton) {
        homeButton.setOnClickListener(v -> {
            Fragment fragment = fragmentManager.findFragmentById(R.id.flContainer);
            if (!(fragment instanceof HomeFragment)) {
                fragment = fragmentManager.findFragmentByTag("HomeFragment");
                if (fragment == null) {
                    fragment = new HomeFragment();
                }
            }
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.replace(R.id.flContainer, fragment, "HomeFragment");
            transaction.addToBackStack(null);
            transaction.commit();
        });

        postButton.setOnClickListener(v -> {
            Fragment fragment = fragmentManager.findFragmentByTag("PostFragment");
            if (fragment == null) {
                fragment = new PostFragment();
            }
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.replace(R.id.flContainer, fragment, "PostFragment");
            transaction.addToBackStack(null);
            transaction.commit();
        });

        profileButton.setOnClickListener(v -> {
            Fragment fragment = fragmentManager.findFragmentByTag("ProfileFragment");
            if (fragment == null) {
                fragment = new ProfileFragment();
            }
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.replace(R.id.flContainer, fragment, "ProfileFragment");
            transaction.addToBackStack(null);
            transaction.commit();
        });
    }
}