package com.example.inigram;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.graphics.PostProcessor;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
    ImageView home, add, profile;
    TextView judul;
    Fragment selectedFragment = null;

    BottomNavigationView bottomNavigation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        home = findViewById(R.id.Homee);
        add = findViewById(R.id.tambah);
        profile = findViewById(R.id.akun);
        judul = findViewById(R.id.judul);


        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedFragment = new HomeFragment();
                judul.setText("Inigram");
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment, HomeFragment.class.getSimpleName()).commit();
            }

        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedFragment = new AddFragment();
                judul.setText("Post");
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment, AddFragment.class.getSimpleName()).commit();
            }
        });
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedFragment = new ProfileFragment();
                judul.setText("Profile");
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment, ProfileFragment.class.getSimpleName()).commit();
            }
        });

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();

    }
}