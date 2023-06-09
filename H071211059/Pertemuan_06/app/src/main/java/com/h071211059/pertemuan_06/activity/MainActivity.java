package com.h071211059.pertemuan_06.activity;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.h071211059.pertemuan_06.fragment.ProfileFragment;
import com.h071211059.pertemuan_06.R;
import com.h071211059.pertemuan_06.fragment.SearchFragment;
import com.h071211059.pertemuan_06.databinding.ActivityMainBinding;
import com.h071211059.pertemuan_06.fragment.AddPostFragment;
import com.h071211059.pertemuan_06.fragment.HomeFragment;
import com.h071211059.pertemuan_06.model.User;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding mainBinding;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mainBinding.getRoot());

        fragmentManager = getSupportFragmentManager();
        HomeFragment homeFragment = HomeFragment.getInstance();
        Fragment fragment =
                fragmentManager.findFragmentByTag(HomeFragment.class.getSimpleName());
        if (!(fragment instanceof HomeFragment)) {
            fragmentManager
                    .beginTransaction()
                    .add(R.id.fl_container, homeFragment,
                            HomeFragment.class.getSimpleName())
                    .commit();
        }

        mainBinding.btnHome.setOnClickListener(v -> switchFragment(HomeFragment.getInstance()));
        mainBinding.btnSearch.setOnClickListener(v -> switchFragment(SearchFragment.getInstance()));
        mainBinding.btnAddPost.setOnClickListener(v -> switchFragment(AddPostFragment.getInstance()));
        mainBinding.btnProfile.setOnClickListener(v -> switchFragment(ProfileFragment.getInstance()));

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

