package com.nitkarsh.modules;

import android.content.Context;

import com.nitkarsh.daggercontext.RandomData;

import dagger.Component;
import retrofit2.Retrofit;

@Component(modules = {RetrofitModule.class,ContextModule.class})
public interface RandomService {

    Retrofit getRetrofit();
    Context getContext();
}
