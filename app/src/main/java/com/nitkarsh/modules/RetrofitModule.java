package com.nitkarsh.modules;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.nitkarsh.daggercontext.RandomData;

import javax.inject.Inject;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class RetrofitModule {

//    @Inject
//    RetrofitModule(){
//
//    }

    @Provides
    public Retrofit getRetrofit(GsonConverterFactory gsonConverterFactory){
        return new Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com").client(new OkHttpClient()).addConverterFactory(gsonConverterFactory).build();

    }

    @Provides
    public Gson getGson(){
        GsonBuilder gson=new GsonBuilder();
        return gson.create();
    }

    @Provides
    public GsonConverterFactory gsonConverterFactory(Gson gson){
        return GsonConverterFactory.create(gson);
    }

    @Provides
    public RandomData getRandom(Retrofit retrofit){
        return retrofit.create(RandomData.class);
    }


}
