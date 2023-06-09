package com.h071211059.pertemuan_07.network;

import com.h071211059.pertemuan_07.models.DataResponse;
import com.h071211059.pertemuan_07.models.UserDataResponse;
import com.h071211059.pertemuan_07.models.UserResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("api/users")
    Call<DataResponse> getUsers(
            @Query("page") int page
    );

    @GET("api/users/{id}")
    Call<UserDataResponse> getUser(
            @Path("id") int id
    );
}
