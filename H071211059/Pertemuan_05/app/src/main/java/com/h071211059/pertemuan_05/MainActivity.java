package com.h071211059.pertemuan_05;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.h071211059.pertemuan_05.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding mainBinding;
    private FragmentManager fragmentManager;
    public static LinkedList<Post> posts = new LinkedList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mainBinding.getRoot());

        fragmentManager = getSupportFragmentManager();
        HomeFragment homeFragment = new HomeFragment();
        Fragment fragment =
                fragmentManager.findFragmentByTag(HomeFragment.class.getSimpleName());
        if (!(fragment instanceof HomeFragment)) {
            fragmentManager
                    .beginTransaction()
                    .add(R.id.fl_container, homeFragment,
                            HomeFragment.class.getSimpleName())
                    .commit();
        }

        mainBinding.btnHome.setOnClickListener(v -> switchFragment(new HomeFragment()));
        mainBinding.btnAddPost.setOnClickListener(v -> switchFragment(new AddPostFragment()));
        mainBinding.btnProfile.setOnClickListener(v -> switchFragment(new ProfileFragment()));
    }

    private void switchFragment(Fragment fragment) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        if (fragment instanceof HomeFragment) {
            transaction
                    .replace(R.id.fl_container, fragment,
                            HomeFragment.class.getSimpleName())
                    .commit();
        } else {
            transaction
                    .replace(R.id.fl_container, fragment,
                            HomeFragment.class.getSimpleName())
                    .addToBackStack(null)
                    .commit();
        }
    }

    @Override
    public void onBackPressed() {
        FragmentManager fragmentManager = getSupportFragmentManager();

        if (fragmentManager.getBackStackEntryCount() > 0) {
            fragmentManager.popBackStackImmediate(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        } else {
            super.onBackPressed();
        }
    }

}