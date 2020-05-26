package com.example.weather.integration.weather;

import com.example.weather.weather.CityWeather;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherService {
    @GET("forecast")
    Call<CityWeather> getWeather(
            @Query("q") String countryName,
            @Query("units") String unit,
            @Query("appid") String appKey
    );
}
