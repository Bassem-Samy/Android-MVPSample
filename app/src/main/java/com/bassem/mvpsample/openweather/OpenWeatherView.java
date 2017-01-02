package com.bassem.mvpsample.openweather;

/**
 * Created by staff on 2017.01.02.
 */

public interface OpenWeatherView {
    void showProgress();

    void hideProgress();

    void setItems();

    void showMessage(String message);

}
