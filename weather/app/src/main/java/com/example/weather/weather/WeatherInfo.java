package com.example.weather.weather;

import java.util.List;

public class WeatherInfo {
    private String dt;
    private String dt_txt;
    private Main main;
    private List<Weather> weather;
    private Wind wind;


    public String getDt_txt() {
        return dt_txt;
    }

    public void setDt_txt(String dt_txt) {
        this.dt_txt = dt_txt;
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

    public String getDt() {
        return dt;
    }

    public void setDt(String dt) {
        this.dt = dt;
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public String getData() {
        return dt;
    }

    public void setData(String name) {
        this.dt = name;
    }
}
