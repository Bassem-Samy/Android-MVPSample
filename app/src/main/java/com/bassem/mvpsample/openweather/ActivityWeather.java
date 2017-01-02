package com.bassem.mvpsample.openweather;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import com.bassem.mvpsample.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ActivityWeather extends AppCompatActivity implements OpenWeatherView {

    private OpenWeatherPresenterImpl presenter;
    @BindView(R.id.rltv_loading)
    RelativeLayout loadingRelativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        presenter = new OpenWeatherPresenterImpl(this);
        ButterKnife.bind(this);
    }

    @Override
    public void showProgress() {
        loadingRelativeLayout.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        loadingRelativeLayout.setVisibility(View.GONE);
    }

    @Override
    public void setItems() {

    }

    @Override
    public void showMessage(String message) {

    }

    @Override
    protected void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }

    @OnClick(R.id.btn_get_weather_data)
    void getWeatherData() {
        presenter.getWeather("cairo, Eg");
    }

}
