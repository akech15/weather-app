package com.example.weather.weather;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class WeatherInfo {
    private long dt;

    @SerializedName("dt_txt")
    private String temperatureDate;

    @SerializedName("main")
    private TemperatureInfo temperatureInfo;
    private List<Weather> weather;
    private Wind wind;

    @SerializedName("clouds")
    private Cloud cloud;

    public Cloud getCloud() {
        return cloud;
    }

    public void setCloud(Cloud cloud) {
        this.cloud = cloud;
    }

    public String getTemperatureDate() {
        return temperatureDate;
    }

    public void setTemperatureDate(String temperatureDate) {
        this.temperatureDate = temperatureDate;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public List<Weather> getWeather() {
        return weather;
    }

    public void setWeather(List<Weather> weather) {
        this.weather = weather;
    }

    public TemperatureInfo getTemperatureInfo() {
        return temperatureInfo;
    }

    public void setTemperatureInfo(TemperatureInfo temperatureInfo) {
        this.temperatureInfo = temperatureInfo;
    }

    public long getData() {
        return dt;
    }

    public void setData(long name) {
        this.dt = name;
    }
}
