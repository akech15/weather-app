package com.example.weather.integration.weather;

import com.example.weather.weather.WeatherInfoWrapper;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherService {
    @GET("forecast")
    Call<WeatherInfoWrapper> getWeather(
            @Query("q") String countryName,
            @Query("appid") String appKey
    );
}
