package com.example.weather.weather;

import java.util.List;

public class CityWeather {
    private List<WeatherInfo> cities;
    private City city;

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public List<WeatherInfo> getCities() {
        return cities;
    }

    public void setCities(List<WeatherInfo> cities) {
        this.cities = cities;
    }
}
