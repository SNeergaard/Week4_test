package com.example.week4_test.model.datasource.retrofit.Retrointer;

import com.example.week4_test.model.samsong.Samsong;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetSamsungService {
    @GET("/photos")
    Call<List<Samsong>> getAllPhotos();
}
