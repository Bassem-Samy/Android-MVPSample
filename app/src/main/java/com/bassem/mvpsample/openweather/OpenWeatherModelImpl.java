package com.bassem.mvpsample.openweather;

import com.bassem.mvpsample.helper.ServiceCallResult;
import com.bassem.mvpsample.services.ServiceConnector;

import retrofit2.Call;

/**
 * Created by staff on 2017.01.01.
 */

public class OpenWeatherModelImpl implements OpenWeatherModel {
    private Call<Object> getWeatherCall;

    @Override
    public void getWeather(String location, ServiceCallResult serviceCallResult) {
        getWeatherCall = ServiceConnector.getWeather(location, serviceCallResult);
    }

    @Override
    public void stopGettingWeather() {
        if (getWeatherCall != null) {
            getWeatherCall.cancel();
            getWeatherCall = null;
        }
    }
}
