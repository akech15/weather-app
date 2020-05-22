package com.example.weather.weather;

import java.util.List;

public class WeatherInfoWrapper {
    private List<WeatherInfo> list;
    private City city;

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public List<WeatherInfo> getList() {
        return list;
    }

    public void setList(List<WeatherInfo> list) {
        this.list = list;
    }
}
