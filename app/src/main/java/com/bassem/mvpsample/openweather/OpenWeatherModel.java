package com.bassem.mvpsample.openweather;

/**
 * Created by staff on 2017.01.01.
 */

public interface OpenWeatherModel {
    public void getWeather(String location,OnGetWeatherFinishedListener OnGetWeatherFinishedListener);
    public void stopGettingWeather();
    public interface OnGetWeatherFinishedListener {
        public void onSuccess(String json);
        public void onError(String errorMessage);
    }
}
