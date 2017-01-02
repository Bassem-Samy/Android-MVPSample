package com.bassem.mvpsample.openweather;

/**
 * Created by staff on 2017.01.02.
 */

public class OpenWeatherPresenterImpl implements OpenWeatherPresenter, OpenWeatherModel.OnGetWeatherFinishedListener {
    private OpenWeatherView weatherView;
    private OpenWeatherModelImpl weatherModel;

    public OpenWeatherPresenterImpl(OpenWeatherView view) {
        this.weatherView = view;
        weatherModel = new OpenWeatherModelImpl();
    }

    @Override
    public void onDestroy() {
        weatherModel.stopGettingWeather();
    }

    @Override
    public void getWeather(String location) {
        weatherModel.getWeather(location, this);
    }

    @Override
    public void onSuccess(String json) {
//weatherview . display data
    }

    @Override
    public void onError(String errorMessage) {
//weather view . show error message
    }
}
