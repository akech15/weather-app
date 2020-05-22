package com.example.weather.utils.retrofit;

import com.example.weather.integration.countries.CountriesService;
import com.example.weather.integration.weather.WeatherService;
import org.jetbrains.annotations.NotNull;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public final class RetrofitHelper {

    private RetrofitHelper() {
    }
    public static CountriesService getCountriesService(@NotNull String url) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(CountriesService.class);
    }

    public static WeatherService getWeatherService(@NotNull String url) {
        Retrofit r = new Retrofit.Builder().baseUrl(url).
                addConverterFactory(GsonConverterFactory.create()).build();
        return r.create(WeatherService.class);
    }

}
