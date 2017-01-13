package com.bassem.mvpsample.services;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by staff on 2017.01.01.
 */

public interface OpenWeatherService {
    @GET("weather")
    Call<String> getWeather(@Query("q") String location, @Query("appid") String appid, @Query("units") String units);
}
