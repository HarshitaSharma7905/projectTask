package com.example.projecttask;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIData {
    @GET("singlesearch/shows?q=girls&embed=episodes")
    Call<DataModel> getData();
}
