package com.bassem.mvpsample.helper;

import com.bassem.mvpsample.model.Weather;
import com.bassem.mvpsample.model.WeatherResult;
import com.google.gson.Gson;

/**
 * Created by staff on 2017.01.02.
 */

public class JsonParser {
    public static WeatherResult parseWeatherResultJson(String json) {
        Gson gson = new Gson();
        WeatherResult result = null;
        try {
            result = gson.fromJson(json, WeatherResult.class);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }
}
