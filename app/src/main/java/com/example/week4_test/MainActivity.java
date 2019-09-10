package com.example.week4_test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.week4_test.model.datasource.retrofit.RetrofitHelper;
import com.example.week4_test.model.datasource.retrofit.Retrointer.GetSamsungService;
import com.example.week4_test.model.samsong.Samsong;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvSamsong;
    private Test4RVAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvSamsong = findViewById(R.id.rvSamsong);

        GetSamsungService service = RetrofitHelper.getRetrofitinstance().create(GetSamsungService.class);
        Call<List<Samsong>> call = service.getAllPhotos();
        call.enqueue(new Callback<List<Samsong>>() {
            @Override
            public void onResponse(Call<List<Samsong>> call, Response<List<Samsong>> response) {
                generateDataList(response.body());
            }

            @Override
            public void onFailure(Call<List<Samsong>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void generateDataList(List<Samsong> samsongList) {

        adapter = new Test4RVAdapter(this, samsongList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        rvSamsong.setLayoutManager(new GridLayoutManager(this, 2));
        rvSamsong.setAdapter(adapter);
    }
}
