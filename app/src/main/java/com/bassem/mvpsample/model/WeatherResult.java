package com.bassem.mvpsample.model;

import com.bassem.mvpsample.helper.Constants;

/**
 * Created by staff on 2017.01.02.
 */

public class WeatherResult {
    private String id;

    private String dt;

    private Clouds clouds;

    private Coord coord;

    private Wind wind;

    private String cod;

    private String visibility;

    private Sys sys;

    private String name;

    private String base;

    private Weather[] weather;

    private MainWeatherInfo main;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDt() {
        return dt;
    }

    public void setDt(String dt) {
        this.dt = dt;
    }

    public Clouds getClouds() {
        return clouds;
    }

    public void setClouds(Clouds clouds) {
        this.clouds = clouds;
    }

    public Coord getCoord() {
        return coord;
    }

    public void setCoord(Coord coord) {
        this.coord = coord;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    public Sys getSys() {
        return sys;
    }

    public void setSys(Sys sys) {
        this.sys = sys;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public Weather[] getWeather() {
        return weather;
    }

    public void setWeather(Weather[] weather) {
        this.weather = weather;
    }

    public MainWeatherInfo getMain() {
        return main;
    }

    public void setMain(MainWeatherInfo main) {
        this.main = main;
    }

    @Override
    public String toString() {
        return "ClassPojo [id = " + id + ", dt = " + dt + ", clouds = " + clouds + ", coord = " + coord + ", wind = " + wind + ", cod = " + cod + ", visibility = " + visibility + ", sys = " + sys + ", name = " + name + ", base = " + base + ", weather = " + weather + ", main = " + main + "]";
    }

    public String getDegree() {
        if (main != null) {
            return main.getTemp();
        }
        return "";
    }

    public String getDescription() {
        if (weather != null && weather.length > 0) {
            return weather[0].getDescription();
        }
        return "";
    }

    public String getWeatherIconUrl() {
        if (weather != null && weather.length > 0) {
            return Constants.IMAGES_BASE_URL + weather[0].getIcon() + Constants.PNG_FILE_EXTENSION;
        }
        return null;
    }

    public String getHumidity() {
        if (main != null) {
            return main.getHumidity();
        }
        return "";
    }

    public String getPressure() {
        if (main != null) {
            return main.getPressure();
        }
        return "";
    }

    public String getMaxTemp() {
        if (main != null) {
            return main.getTemp_max();
        }
        return "";
    }

    public String getMinTemp() {
        if (main != null) {
            return main.getTemp_min();
        }
        return "";
    }
}
