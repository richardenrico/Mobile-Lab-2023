package com.h071211059.pertemuan_06.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

import com.h071211059.pertemuan_06.fragment.ProfileFragment;
import com.h071211059.pertemuan_06.R;
import com.h071211059.pertemuan_06.model.User;
import com.h071211059.pertemuan_06.databinding.ActivityProfileBinding;
import com.h071211059.pertemuan_06.fragment.HomeFragment;

public class ProfileActivity extends AppCompatActivity {
    private ActivityProfileBinding binding;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProfileBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        User user = (User) getIntent().getParcelableExtra("user");


        fragmentManager = getSupportFragmentManager();
        ProfileFragment profileFragment = ProfileFragment.getInstance();
        Fragment fragment =
                fragmentManager.findFragmentByTag(HomeFragment.class.getSimpleName());

        Bundle bundle = new Bundle();
        bundle.putParcelable("user", user);
        profileFragment.setArguments(bundle);

        if (!(fragment instanceof HomeFragment)) {
            fragmentManager
                    .beginTransaction()
                    .add(R.id.fl_container, profileFragment,
                            HomeFragment.class.getSimpleName())
                    .commit();
        }
    }
}