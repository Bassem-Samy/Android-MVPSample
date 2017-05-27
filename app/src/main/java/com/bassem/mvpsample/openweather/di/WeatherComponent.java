package com.bassem.mvpsample.openweather.di;

import com.bassem.mvpsample.ActivityMain;
import com.bassem.mvpsample.openweather.ActivityWeather;

import javax.inject.Singleton;

import dagger.Component;
import dagger.Module;

/**
 * Created by Bassem Samy on 5/27/2017.
 */
@Singleton
@Component(modules = {WeatherModule.class})
public interface WeatherComponent {
    void inject(ActivityWeather target);
}
