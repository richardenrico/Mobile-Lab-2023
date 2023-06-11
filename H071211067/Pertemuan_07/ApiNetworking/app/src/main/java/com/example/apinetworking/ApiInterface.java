package com.example.apinetworking;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("api/users")
    //Call every page
    Call<Result> getUser(@Query("page") int page, @Query("per_page") int perPage);

    @GET("api/users/{id}")
    Call<ResultProfile> getProfile(@Path("id") String id);

}
