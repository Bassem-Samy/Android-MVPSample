package com.bassem.mvpsample.openweather;

import android.util.Log;

import com.bassem.mvpsample.model.WeatherResult;

/**
 * Created by staff on 2017.01.02.
 */

public class OpenWeatherPresenterImpl implements OpenWeatherPresenter, OpenWeatherModel.OnGetWeatherFinishedListener {
    private OpenWeatherView weatherView;
    private OpenWeatherModel weatherModel;

    public OpenWeatherPresenterImpl(OpenWeatherView view,OpenWeatherModel model) {
        this.weatherView = view;
        weatherModel = model;
    }

    @Override
    public void onDestroy() {
        weatherModel.stopGettingWeather();
    }

    @Override
    public void getWeather(String location) {
        weatherView.showProgress();
        weatherModel.getWeather(location, this);
    }

    @Override
    public void onSuccess(WeatherResult result) {
        weatherView.hideProgress();
        weatherView.populateData(result);
        Log.e("result", result.toString());
//weatherview . display data
    }

    @Override
    public void onError(String errorMessage) {
        weatherView.hideProgress();
//weather view . show error message
    }
}
