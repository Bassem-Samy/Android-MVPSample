package com.bassem.mvpsample.openweather;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bassem.mvpsample.R;
import com.bassem.mvpsample.model.WeatherResult;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ActivityWeather extends AppCompatActivity implements OpenWeatherView {

    private OpenWeatherPresenterImpl presenter;
    @BindView(R.id.rltv_loading)
    RelativeLayout loadingRelativeLayout;

    @BindView(R.id.cv_data)
    CardView dataCardView;
    @BindView(R.id.txt_weather)
    TextView weatherText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        presenter = new OpenWeatherPresenterImpl(this);
        ButterKnife.bind(this);
    }

    @Override
    public void showProgress() {
        dataCardView.setVisibility(View.GONE);
        loadingRelativeLayout.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {

        dataCardView.setVisibility(View.VISIBLE);
        loadingRelativeLayout.setVisibility(View.GONE);
    }

    @Override
    public void populateData(WeatherResult weatherData) {
        weatherText.setText(weatherData.getName());
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
