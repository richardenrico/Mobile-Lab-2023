package com.example.tp_mobile_9;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.facebook.shimmer.ShimmerFrameLayout;

import de.hdodenhof.circleimageview.CircleImageView;

public class ProfileActivity extends AppCompatActivity {

    private RelativeLayout rlContentProfile;
    CircleImageView civProfilePictureProfileActivity;
    TextView tvFullNameProfileActivity, tvEmailProfileActivity;

    private ShimmerFrameLayout shimmerFrameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        rlContentProfile =findViewById(R.id.rlContentProfile);

        shimmerFrameLayout = findViewById(R.id.shimmer);
        shimmerFrameLayout.startShimmer();

        civProfilePictureProfileActivity = findViewById(R.id.civProfilePictureProfileActivity);
        tvFullNameProfileActivity = findViewById(R.id.tvFullNameProfileActivity);
        tvEmailProfileActivity = findViewById(R.id.tvEmailProfileActivity);

        String avatarUrl = getIntent().getStringExtra("avatarUrl");
        String fullName = getIntent().getStringExtra("fullName");
        String userEmail = getIntent().getStringExtra("email");

        Glide.with(this)
                .load(avatarUrl)
                .into(civProfilePictureProfileActivity);
        tvFullNameProfileActivity.setText(fullName);
        tvEmailProfileActivity.setText(userEmail);

        Thread shimmerThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        shimmerFrameLayout.stopShimmer();
                        shimmerFrameLayout.setVisibility(View.GONE);

                        rlContentProfile.setVisibility(View.VISIBLE);

                    }
                });
            }
        });
        shimmerThread.start();
    }
}
