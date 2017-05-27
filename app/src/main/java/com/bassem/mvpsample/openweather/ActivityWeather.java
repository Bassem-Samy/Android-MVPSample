package com.bassem.mvpsample.openweather;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bassem.mvpsample.R;
import com.bassem.mvpsample.model.WeatherResult;
import com.bassem.mvpsample.openweather.di.DaggerWeatherComponent;
import com.bassem.mvpsample.openweather.di.WeatherModule;
import com.squareup.picasso.Picasso;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnEditorAction;

public class ActivityWeather extends AppCompatActivity implements OpenWeatherView {
    @Inject
    OpenWeatherPresenterImpl presenter;
    @BindView(R.id.rltv_loading)
    RelativeLayout loadingRelativeLayout;

    @BindView(R.id.cv_data)
    CardView dataCardView;
    @BindView(R.id.cv_data2)
    CardView dataCardView2;
    @BindView(R.id.txt_name)
    TextView nameTextView;
    @BindView(R.id.txt_degree)
    TextView degreeTextView;
    @BindView(R.id.txt_description)
    TextView descriptionTextView;
    @BindView(R.id.txt_pressure)
    TextView pressureTextView;
    @BindView(R.id.txt_humidity)
    TextView humidityTextView;
    @BindView(R.id.txt_min_temp)
    TextView minimumTempTextView;
    @BindView(R.id.txt_max_temp)
    TextView maxTempTextView;
    @BindView(R.id.img_weather_icon)
    ImageView weatherIconImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        //presenter = new OpenWeatherPresenterImpl(this);
        ButterKnife.bind(this);
        DaggerWeatherComponent.builder().weatherModule(new WeatherModule(this)).build().inject(this);
    }

    @Override
    public void showProgress() {
        dataCardView.setVisibility(View.GONE);
        dataCardView2.setVisibility(View.GONE);
        loadingRelativeLayout.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {

        dataCardView.setVisibility(View.VISIBLE);
        dataCardView2.setVisibility(View.VISIBLE);

        loadingRelativeLayout.setVisibility(View.GONE);
    }

    @Override
    public void populateData(WeatherResult weatherData) {
        populateUI(weatherData);
    }

    private void populateUI(WeatherResult weatherData) {
        nameTextView.setText(weatherData.getName());
        degreeTextView.setText(weatherData.getDegree());
        descriptionTextView.setText(weatherData.getDescription());
        pressureTextView.setText(weatherData.getPressure());
        humidityTextView.setText(weatherData.getHumidity());
        maxTempTextView.setText(weatherData.getMaxTemp());
        minimumTempTextView.setText(weatherData.getMinTemp());
        if (weatherData.getWeatherIconUrl() != null) {
            Picasso.with(this).load(weatherData.getWeatherIconUrl()).resize(50, 50).centerInside().into(weatherIconImageView);
        }

    }

    @Override
    public void showMessage(String message) {

    }

    @Override
    protected void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }


    @OnEditorAction(R.id.edt_search)
    boolean onSearchEditorAction(TextView v, int actionId, KeyEvent event) {

        if (actionId == EditorInfo.IME_ACTION_SEARCH || event != null && event.getAction() == KeyEvent.ACTION_DOWN) {
            // Perform action on key press
            Log.e("tv", "KEYCODE_ENTER");
            if (v.getText().toString() != null && !v.getText().toString().isEmpty()) {
                presenter.getWeather(v.getText().toString());
            } else {
                Toast.makeText(this, R.string.please_enter_search_city, Toast.LENGTH_SHORT).show();
            }
            return true;
        }
        return false;
    }
}
