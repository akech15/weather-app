package com.example.weather.weather;

import com.google.gson.annotations.SerializedName;

public class TemperatureInfo {
    private String temp;
    private String humidity;

    @SerializedName("feels_like")
    private String feelsLike;

    public String getFeelsLike() {
        return feelsLike;
    }

    public void setFeelsLike(String feelsLike) {
        this.feelsLike = feelsLike;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }
}
