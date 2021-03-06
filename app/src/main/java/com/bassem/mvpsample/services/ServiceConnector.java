package com.bassem.mvpsample.services;

import com.bassem.mvpsample.helper.ServiceCallResultListener;
import com.bassem.mvpsample.helper.ToStringConverterFactory;

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


    public static Call<String> getWeather(String location,String units, final ServiceCallResultListener serviceCallResultListener) {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(WEATHER_BASE_URL)
                .addConverterFactory(new ToStringConverterFactory())
                .build();
        OpenWeatherService service = retrofit.create(OpenWeatherService.class);
        Call<String> getWeatherServiceCall = service.getWeather(location, WEATHER_APP_ID,units);
        getWeatherServiceCall.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if (serviceCallResultListener != null) {
                    serviceCallResultListener.onResponse(response.body());
                }
            }


            @Override
            public void onFailure(Call<String> call, Throwable t) {
                if (serviceCallResultListener != null) {
                    serviceCallResultListener.onError(t);
                }
            }
        });
        return getWeatherServiceCall;

    }

}
