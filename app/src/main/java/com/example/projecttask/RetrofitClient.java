package com.example.projecttask;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    public static Retrofit retrofit;
    public static Retrofit retrofitInstance(){
        retrofit =new Retrofit.Builder()
                .baseUrl("https://api.tvmaze.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }
}
