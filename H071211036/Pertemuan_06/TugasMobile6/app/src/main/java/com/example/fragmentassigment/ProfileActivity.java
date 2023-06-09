package com.example.fragmentassigment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class ProfileActivity extends AppCompatActivity {

    public static final String EXTRA_USER = "extra_user";
    private ProgressBar progressBar;
    private TextView tvUser, tvName, tvDesc;
    private LinearLayout linearLayout;
    private ImageView profile, header;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        linearLayout = findViewById(R.id.linearLayout);
        tvUser = findViewById(R.id.tv_user);
        tvName = findViewById(R.id.tv_name);
        tvDesc = findViewById(R.id.tv_desc);
        profile = findViewById(R.id.iv_profile);
        header = findViewById(R.id.iv_header);
        progressBar = findViewById(R.id.pb_profile);

        LoadProfileTask loadProfileTask = new LoadProfileTask();
        loadProfileTask.execute();
    }

    private class LoadProfileTask extends AsyncTask<Void, Void, PostModel> {

        @Override
        protected void onPreExecute() {
            progressBar.setVisibility(View.VISIBLE);
            linearLayout.setVisibility(View.GONE);
        }

        @Override
        protected PostModel doInBackground(Void... voids) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            PostModel postModel = getIntent().getParcelableExtra(EXTRA_USER);
            return postModel;
        }

        @Override
        protected void onPostExecute(PostModel postModel) {
            progressBar.setVisibility(View.GONE);
            linearLayout.setVisibility(View.VISIBLE);

            tvName.setText(postModel.getName());
            tvUser.setText(postModel.getUsername());
            tvDesc.setText(postModel.getDesc());

            Glide.with(ProfileActivity.this)
                    .load(postModel.getProfile())
                    .into(profile);

            Glide.with(ProfileActivity.this)
                    .load(postModel.getHeader())
                    .into(header);
        }
    }
}