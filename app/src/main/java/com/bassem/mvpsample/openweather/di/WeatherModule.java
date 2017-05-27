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

    /**
     * You can replace this with adding @Inject annotation over the presenterimpl constructor, and dagger will use the graph up here to inject it's constructor
     * but the point is by keeping it here, we can provide a mock presenter for instance so this approach is better for testing
     * @param view
     * @param model
     * @return
     */
    @Singleton
    @Provides
    public OpenWeatherPresenterImpl providesOpenWeatherPresenterImpl(OpenWeatherView view, OpenWeatherModel model) {
        return new OpenWeatherPresenterImpl(view, model);
    }


}
