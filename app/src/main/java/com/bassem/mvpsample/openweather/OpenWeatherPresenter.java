package com.bassem.mvpsample.openweather;

/**
 * Created by staff on 2017.01.02.
 */

public interface OpenWeatherPresenter {
    public void onDestroy();
    void getWeather(String location);
}
