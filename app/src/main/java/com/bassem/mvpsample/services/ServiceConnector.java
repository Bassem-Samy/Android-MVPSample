package com.bassem.mvpsample.services;

import com.bassem.mvpsample.helper.ServiceCallResult;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by staff on 2017.01.01.
 */

public class ServiceConnector {
    static final String WEATHER_BASE_URL = "http://api.openweathermap.org/data/2.5/";
    static final String WEATHER_APP_ID = "3cb726822c464af37bbbbb89747e7640";

    public static void getWeather(String location, final ServiceCallResult serviceCallResult) {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(WEATHER_BASE_URL).build();
        OpenWeatherService service = retrofit.create(OpenWeatherService.class);
        Call<Object> call = service.getWeather(location, WEATHER_APP_ID);
        call.enqueue(new Callback<Object>() {
            @Override
            public void onResponse(Call<Object> call, Response<Object> response) {
                if (serviceCallResult != null) {
                    serviceCallResult.onResponse(response.toString());
                }
            }

            @Override
            public void onFailure(Call<Object> call, Throwable t) {
                if (serviceCallResult != null) {
                    serviceCallResult.onError(t);
                }
            }
        });
    }
}
