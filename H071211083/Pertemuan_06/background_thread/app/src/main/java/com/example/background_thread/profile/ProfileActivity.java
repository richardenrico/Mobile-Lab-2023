package com.example.background_thread.profile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.ProgressBar;

import com.example.background_thread.R;
import com.example.background_thread.data.model.User;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ProfileActivity extends AppCompatActivity {

    public static final String EXTRA_USER = "extra_user";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Executor executor = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());

        executor.execute(()-> {
            try {
                Thread.sleep(500);
            }catch (InterruptedException e){
                throw new RuntimeException(e);
            }
            handler.post(()-> {
                ProgressBar progressBar = findViewById(R.id.pb_profile);
                progressBar.setVisibility(View.GONE);

                FragmentManager fragmentManager = getSupportFragmentManager();
                Fragment fragment = fragmentManager.findFragmentByTag(ProfileFragment.class.getSimpleName());
                if (!(fragment instanceof ProfileFragment)){
                    ProfileFragment profileFragment = new ProfileFragment();
                    User user = getIntent().getParcelableExtra(EXTRA_USER);
                    System.out.println("asda"+user.getFullname());
                    profileFragment.setUser(user);
                    fragmentManager
                        .beginTransaction()
                        .add(R.id.profile_container, profileFragment, ProfileFragment.class.getSimpleName())
                        .commit();
                }
            });
        });

    }
}