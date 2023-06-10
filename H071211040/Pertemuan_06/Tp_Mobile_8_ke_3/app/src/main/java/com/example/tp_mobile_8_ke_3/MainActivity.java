package com.example.tp_mobile_8_ke_3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView btn_home, btn_add, btn_profile, btn_search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_home = findViewById(R.id.home_button);
        btn_add = findViewById(R.id.add_button);
        btn_profile = findViewById(R.id.profile_button);
        btn_search = findViewById(R.id.search_button);

        FragmentManager fragmentManager = getSupportFragmentManager();
        HomeFragment homeFragment = new HomeFragment();
        Fragment fragment = fragmentManager.findFragmentByTag(HomeFragment.class.getSimpleName());
        if (!(fragment instanceof HomeFragment)) {
            fragmentManager.beginTransaction().add(R.id.container, homeFragment,
                    HomeFragment.class.getSimpleName()).commit();
        }

        btn_home.setOnClickListener( v -> switchFragment(new HomeFragment()) );
        btn_add.setOnClickListener( v -> switchFragment(new PostFragment()));
        btn_profile.setOnClickListener( v -> switchFragment(new ProfileFragment()));
        btn_search.setOnClickListener( v -> switchFragment(new SearchFragment()));
    }

    private void switchFragment(Fragment fragment){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        if(fragment instanceof HomeFragment){
            transaction.replace(R.id.container, fragment, HomeFragment.class.getSimpleName()).commit();
        } else {
            transaction.replace(R.id.container, fragment, HomeFragment.class.getSimpleName()).addToBackStack(null).commit();
        }
    }
}