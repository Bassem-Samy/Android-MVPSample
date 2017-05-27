package com.bassem.mvpsample.openweather.di;

import com.bassem.mvpsample.openweather.OpenWeatherModel;
import com.bassem.mvpsample.openweather.OpenWeatherModelImpl;
import com.bassem.mvpsample.openweather.OpenWeatherPresenterImpl;
import com.bassem.mvpsample.openweather.OpenWeatherView;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Bassem Samy on 5/27/2017.
 */
@Module
public class WeatherModule {
    private OpenWeatherView view;

    public WeatherModule(OpenWeatherView view) {
        this.view = view;
    }

    @Singleton
    @Provides
    public OpenWeatherView providesOpenWeatherView() {
        return this.view;
    }

    @Singleton
    @Provides
    public OpenWeatherModel providesOpenWeatherModelImpl() {
        return new OpenWeatherModelImpl();
    }

    @Singleton
    @Provides
    public OpenWeatherPresenterImpl providesOpenWeatherPresenterImpl(OpenWeatherView view, OpenWeatherModel model) {
        return new OpenWeatherPresenterImpl(view, model);
    }


}
