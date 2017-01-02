package com.bassem.mvpsample.openweather;

import com.bassem.mvpsample.helper.ServiceCallResultListener;
import com.bassem.mvpsample.services.ServiceConnector;

import retrofit2.Call;

/**
 * Created by staff on 2017.01.01.
 */

public class OpenWeatherModelImpl implements OpenWeatherModel, ServiceCallResultListener {
    private Call<Object> getWeatherCall;
    private OnGetWeatherFinishedListener mListener;

    @Override
    public void getWeather(String location, OnGetWeatherFinishedListener listener) {
        mListener = listener;
        getWeatherCall = ServiceConnector.getWeather(location, this);
    }

    @Override
    public void stopGettingWeather() {
        if (getWeatherCall != null) {
            getWeatherCall.cancel();
            getWeatherCall = null;
        }
    }

    @Override
    public void onResponse(String json) {
        mListener.onSuccess(json);
    }

    @Override
    public void onError(Throwable throwable) {
        if (throwable != null) {
            mListener.onError(throwable.getMessage());
        } else {
            mListener.onError("");
        }
    }
}
