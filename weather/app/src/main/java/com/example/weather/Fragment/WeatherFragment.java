package com.example.weather.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.weather.R;
import com.example.weather.integration.weather.WeatherService;
import com.example.weather.integration.weather.WeatherServiceParams;
import com.example.weather.utils.retrofit.RetrofitHelper;
import com.example.weather.weather.CityWeather;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WeatherFragment extends Fragment {
    private String country;

    public static WeatherFragment newInstance(String countryName) {
        Bundle args = new Bundle();
        args.putString("country", countryName);
        WeatherFragment fragment = new WeatherFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        country = this.getArguments().getString("country");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_weather, null);
        initConnection();
        return view;
    }

    private void initConnection() {
        WeatherService weatherService = RetrofitHelper.getWeatherService(WeatherServiceParams.URL);
        createWeatherApiResponse(weatherService);
    }


    private void createWeatherApiResponse(WeatherService weatherService) {
        weatherService.getWeather(country, WeatherServiceParams.key).enqueue(new Callback<CityWeather>() {
            @Override
            public void onResponse(Call<CityWeather> call, Response<CityWeather> response) {
                if (response.isSuccessful()) {

                }else{
                    initConnection();
                }
            }

            @Override
            public void onFailure(Call<CityWeather> call, Throwable t) {
                initConnection();
            }
        });
    }
}
