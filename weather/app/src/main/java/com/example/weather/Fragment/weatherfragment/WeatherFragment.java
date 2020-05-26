package com.example.weather.Fragment.weatherfragment;

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
        View view = inflater.inflate(R.layout.app_finished_graphic, null);
        initConnectionAndDownloadWeatherDataAsyncAndDraw(view);
        return view;
    }

    private void initConnectionAndDownloadWeatherDataAsyncAndDraw(View view) {
        WeatherService weatherService = RetrofitHelper.getWeatherService(WeatherServiceParams.URL);
        createWeatherApiResponse(weatherService, view);
    }

    private void createWeatherApiResponse(WeatherService weatherService, View view) {
        weatherService.getWeather(country, "metric", WeatherServiceParams.key).enqueue(new Callback<CityWeather>() {
            @Override
            public void onResponse(Call<CityWeather> call, Response<CityWeather> response) {
                if (response.isSuccessful()) {
                    CityWeather cityWeather = response.body();
                    drawAppMainWindow(view, cityWeather);
                } else {
                    initConnectionAndDownloadWeatherDataAsyncAndDraw(view);
                }
            }

            @Override
            public void onFailure(Call<CityWeather> call, Throwable t) {
                initConnectionAndDownloadWeatherDataAsyncAndDraw(view);
            }
        });
    }

    private void drawAppMainWindow(View view, CityWeather cityWeather) {
        drawNorthLayout(view, cityWeather);
        drawMiddleLayout(view, cityWeather);
    }

    private void drawMiddleLayout(View view, CityWeather cityWeather) {
        WeatherFragmentMiddleLayoutDrawer middleLayout = new WeatherFragmentMiddleLayoutDrawer(view, cityWeather);
        middleLayout.draw();
    }

    private void drawNorthLayout(View view, CityWeather cityWeather) {
        WeatherFragmentNorthLayoutDrawer weatherFragmentNorthLayoutDrawer = new WeatherFragmentNorthLayoutDrawer(view, cityWeather, country);
        weatherFragmentNorthLayoutDrawer.draw();
    }

}
