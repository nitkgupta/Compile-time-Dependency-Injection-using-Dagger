package com.nitkarsh.daggercontext;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.nitkarsh.modules.ContextModule;
import com.nitkarsh.modules.DaggerRandomService;
import com.nitkarsh.modules.RandomService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    private Retrofit retrofit;
    RandomService randomService;
    List<RetroData> list;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recycler_view);
        randomService= DaggerRandomService.builder().contextModule(new ContextModule(this)).build();
        retrofit=randomService.getRetrofit();
        addData();
        recyclerView.addItemDecoration(new DividerItemDecoration(randomService.getContext(),DividerItemDecoration.VERTICAL));
        recyclerView.setLayoutManager(new LinearLayoutManager(randomService.getContext()));

    }

    private void addData() {
        RandomData randomData=retrofit.create(RandomData.class);
        Call<List<RetroData>> data = randomData.getComments();
        data.enqueue(new Callback<List<RetroData>>() {
            @Override
            public void onResponse(Call<List<RetroData>> call, Response<List<RetroData>> response) {
                list=response.body();
                Log.v("CHECKING",list+"");
                recyclerView.setAdapter(new RandomAdapter(randomService.getContext(),list));
            }

            @Override
            public void onFailure(Call<List<RetroData>> call, Throwable t) {
                Log.v("CHECKING",t.toString());
            }
        });
    }
}
