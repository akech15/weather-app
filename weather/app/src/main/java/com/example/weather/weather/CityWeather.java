package com.example.weather.weather;

import java.util.List;

public class CityWeather {

    private City city;
    private List<WeatherInfo> list;

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
