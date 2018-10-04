package com.nitkarsh.daggercontext;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RandomData {

    @GET("/comments")
    Call<List<RetroData>> getComments();
}
