package com.bassem.mvpsample.openweather;

import com.bassem.mvpsample.model.WeatherResult;

/**
 * Created by staff on 2017.01.02.
 */

public interface OpenWeatherView {
    void showProgress();

    void hideProgress();

    void populateData(WeatherResult weatherData);

    void showMessage(String message);

}
