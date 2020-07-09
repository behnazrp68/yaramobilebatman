package com.rajabi.rajabibatmanyara.networking;

import com.rajabi.rajabibatmanyara.models.Movies;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieListApiService {
    @GET("?")
    Call<String> getMovies(
            @Query("s") String s,
            @Query("apiKey") String apiKey
    );

    @GET("?")
    Call<String> getDetailMovies(
            @Query("i") String imdbid,
            @Query("apiKey") String apiKey
    );
}
