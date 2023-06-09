package com.h071211059.pertemuan_07.activities;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.h071211059.pertemuan_07.databinding.ActivityProfileBinding;
import com.h071211059.pertemuan_07.models.UserDataResponse;
import com.h071211059.pertemuan_07.models.UserResponse;
import com.h071211059.pertemuan_07.network.ApiInstance;
import com.h071211059.pertemuan_07.network.ApiInterface;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ProfileActivity extends AppCompatActivity {
    public static final String EXTRA_USER = "user";
    private ActivityProfileBinding binding;
    private int userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProfileBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        this.userId = getIntent().getIntExtra(EXTRA_USER, 0);
        showUser(userId);
    }

    private void showUser(int userId) {
        Retrofit retrofit = ApiInstance.getInstance();
        ApiInterface apiInterface = retrofit.create(ApiInterface.class);
        Call<UserDataResponse> client = apiInterface.getUser(userId);

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(getMainLooper());

        executorService.execute(() -> client.enqueue(new Callback<UserDataResponse>() {
            @Override
            public void onResponse(Call<UserDataResponse> call, Response<UserDataResponse> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        UserResponse user = response.body().getData();
                        handler.post(() -> {
                            binding.progressBar.setVisibility(View.GONE);
                            binding.llUser.setVisibility(View.VISIBLE);

                            binding.tvName.setText(user.getFirstName() + " " + user.getLastName());
                            binding.tvUsername.setText(user.getEmail());
                            Glide.with(binding.getRoot()).load(user.getAvatarUrl()).into(binding.ivProfile);
                        });
                    }
                }
            }

            @Override
            public void onFailure(Call<UserDataResponse> call, Throwable t) {
                showNetworkErrorInfo(userId);
            }
        }));
    }

    private void showNetworkErrorInfo(int userId) {
        binding.progressBar.setVisibility(View.GONE);
        binding.networkError.getRoot().setVisibility(View.VISIBLE);

        binding.networkError.getRoot().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.networkError.getRoot().setVisibility(View.GONE);
                showUser(userId);
            }
        });
    }
}