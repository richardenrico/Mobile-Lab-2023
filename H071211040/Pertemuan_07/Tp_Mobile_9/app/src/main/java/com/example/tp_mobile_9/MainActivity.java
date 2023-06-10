package com.example.tp_mobile_9;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;

import com.facebook.shimmer.ShimmerFrameLayout;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvMainActivity;
    private UserAdapter userAdapter;
    private List<UserResponse> usersPage1;
    private List<UserResponse> usersPage2;

    private ShimmerFrameLayout shimmerFrameLayout;

    private RelativeLayout rlFailLoad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvMainActivity = findViewById(R.id.rvMainActivity);

        shimmerFrameLayout = findViewById(R.id.shimmer);
        shimmerFrameLayout.startShimmer();

        rlFailLoad = findViewById(R.id.rlFailLoad);

        usersPage1 = new ArrayList<>();
        usersPage2 = new ArrayList<>();

        Call<DataResponse> clientPage1 = ApiConfig.getApiService().getUser(1);
        clientPage1.enqueue(new Callback<DataResponse>() {
            @Override
            public void onResponse(Call<DataResponse> call, Response<DataResponse> response) {
                if (response.isSuccessful()) {

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
                                    rvMainActivity.setVisibility(View.VISIBLE);
                                    loadUsers();
                                }
                            });
                        }
                    });
                    shimmerThread.start();

                    if (response.body() != null) {
                        usersPage1 = response.body().getData();
                        loadUsers();
                    }
                } else {
                    if (response.body() != null) {
                        Log.e("MainActivity", "onFailure: " + response.message());
                    }
                }
            }

            @Override
            public void onFailure(Call<DataResponse> call, Throwable t) {
                rlFailLoad.setVisibility(View.VISIBLE);
                shimmerFrameLayout.setVisibility(View.GONE);
                rvMainActivity.setVisibility(View.GONE);

                rlFailLoad.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        rlFailLoad.setVisibility(View.GONE);
                        shimmerFrameLayout.setVisibility(View.VISIBLE);
                        rvMainActivity.setVisibility(View.GONE);

                        shimmerFrameLayout.startShimmer();

                        Call<DataResponse> clientPage1 = ApiConfig.getApiService().getUser(1);
                        clientPage1.enqueue(new Callback<DataResponse>() {
                            @Override
                            public void onResponse(Call<DataResponse> call, Response<DataResponse> response) {
                                if (response.isSuccessful()) {

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
                                                    rvMainActivity.setVisibility(View.VISIBLE);
                                                    loadUsers();
                                                }
                                            });
                                        }
                                    });
                                    shimmerThread.start();

                                    if (response.body() != null) {
                                        usersPage1 = response.body().getData();
                                        loadUsers();
                                    }
                                } else {
                                    if (response.body() != null) {
                                        Log.e("MainActivity", "onFailure: " + response.message());
                                    }
                                }
                            }

                            @Override
                            public void onFailure(Call<DataResponse> call, Throwable t) {
                                rlFailLoad.setVisibility(View.VISIBLE);
                                shimmerFrameLayout.setVisibility(View.GONE);
                                rvMainActivity.setVisibility(View.GONE);
                                Log.e("MainActivity", "onFailure: " + t.getMessage());
                            }
                        });

                        Call<DataResponse> clientPage2 = ApiConfig.getApiService().getUser(2);
                        clientPage2.enqueue(new Callback<DataResponse>() {
                            @Override
                            public void onResponse(Call<DataResponse> call, Response<DataResponse> response) {
                                if (response.isSuccessful()) {

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
                                                    rvMainActivity.setVisibility(View.VISIBLE);
                                                    loadUsers();
                                                }
                                            });
                                        }
                                    });
                                    shimmerThread.start();

                                    if (response.body() != null) {
                                        usersPage2 = response.body().getData();
                                        loadUsers();
                                    }
                                } else {
                                    if (response.body() != null) {
                                        Log.e("MainActivity", "onFailure: " + response.message());
                                    }
                                }
                            }

                            @Override
                            public void onFailure(Call<DataResponse> call, Throwable t) {
                                Log.e("MainActivity", "onFailure: " + t.getMessage());
                            }
                        });


                    }
                });
            }
        });


        Call<DataResponse> clientPage2 = ApiConfig.getApiService().getUser(2);
        clientPage2.enqueue(new Callback<DataResponse>() {
            @Override
            public void onResponse(Call<DataResponse> call, Response<DataResponse> response) {
                if (response.isSuccessful()) {

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
                                    rvMainActivity.setVisibility(View.VISIBLE);
                                    loadUsers();
                                }
                            });
                        }
                    });
                    shimmerThread.start();

                    if (response.body() != null) {
                        usersPage2 = response.body().getData();
                        loadUsers();
                    }
                } else {
                    if (response.body() != null) {
                        Log.e("MainActivity", "onFailure: " + response.message());
                    }
                }
            }

            @Override
            public void onFailure(Call<DataResponse> call, Throwable t) {
                Log.e("MainActivity", "onFailure: " + t.getMessage());
            }
        });
    }

    private void loadUsers() {

        List<UserResponse> allUsers = new ArrayList<>();
        allUsers.addAll(usersPage1);
        allUsers.addAll(usersPage2);

        userAdapter = new UserAdapter(allUsers, MainActivity.this);
        rvMainActivity.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        rvMainActivity.setAdapter(userAdapter);
    }
}