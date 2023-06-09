package com.h071211059.pertemuan_07.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.h071211059.pertemuan_07.adapters.UserAdapter;
import com.h071211059.pertemuan_07.databinding.ActivityMainBinding;
import com.h071211059.pertemuan_07.models.DataResponse;
import com.h071211059.pertemuan_07.models.UserResponse;
import com.h071211059.pertemuan_07.network.ApiInstance;
import com.h071211059.pertemuan_07.network.ApiInterface;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.rvUsers.setLayoutManager(new LinearLayoutManager(this));

        getUsersList();
    }

    private void getUsersList() {
        binding.progressBar.setVisibility(View.VISIBLE);
        Retrofit retrofit = ApiInstance.getInstance();
        ApiInterface apiInterface = retrofit.create(ApiInterface.class);
        Call<DataResponse> client = apiInterface.getUsers(1);

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());

        executorService.execute(new Runnable() {
            @Override
            public void run() {
                client.enqueue(new Callback<DataResponse>() {
                    @Override
                    public void onResponse(Call<DataResponse> call, Response<DataResponse> response) {
                        if (response.isSuccessful()) {
                            if (response.body() != null) {
                                ArrayList<UserResponse> users = response.body().getData();
                                handler.post(() -> {
                                    UserAdapter adapter = new UserAdapter(users);
                                    adapter.setOnItemClickCallback((UserResponse user) -> {
                                        gotoProfile(user);
                                    });
                                    binding.rvUsers.setAdapter(adapter);
                                    binding.progressBar.setVisibility(View.GONE);
                                });
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<DataResponse> call, Throwable t) {
                        System.out.println(t.getLocalizedMessage());
                        showNetworkErrorInfo();
                    }
                });

            }
        });
    }

    private void showNetworkErrorInfo() {
        binding.progressBar.setVisibility(View.GONE);
        binding.networkError.getRoot().setVisibility(View.VISIBLE);
        
        binding.networkError.getRoot().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.networkError.getRoot().setVisibility(View.GONE);
                getUsersList();
            }
        });
    }

    private void gotoProfile(UserResponse user) {
        Intent intent = new Intent(this, ProfileActivity.class);
        intent.putExtra(ProfileActivity.EXTRA_USER, user.getId());
        startActivity(intent);
    }
}