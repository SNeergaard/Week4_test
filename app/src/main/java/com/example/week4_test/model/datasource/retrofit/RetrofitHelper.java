package com.example.week4_test.model.datasource.retrofit;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitHelper {
    private static Retrofit retrofit;
    private static  String URL = "https://jsonplaceholder.typicode.com/photos/";

    public static Retrofit getRetrofitinstance(){
        if (retrofit == null){
            retrofit = new retrofit2.Retrofit.Builder().baseUrl(URL)
            .addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }

}
