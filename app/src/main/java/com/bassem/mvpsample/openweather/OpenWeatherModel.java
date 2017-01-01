package com.bassem.mvpsample.openweather;

import com.bassem.mvpsample.helper.ServiceCallResult;

/**
 * Created by staff on 2017.01.01.
 */

public interface OpenWeatherModel {
    public void getWeather(String location,ServiceCallResult serviceCallResult);
    public void stopGettingWeather();
}
