package com.example.weather;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import com.example.weather.integration.weather.WeatherService;
import com.example.weather.integration.weather.WeatherServiceParams;
import com.example.weather.utils.retrofit.RetrofitHelper;
import com.example.weather.weather.WeatherInfoWrapper;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WeatherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tester);

        WeatherService weatherService = RetrofitHelper.getWeatherService(WeatherServiceParams.URL);
        createWeatherApiResponse(weatherService);
    }

    private void createWeatherApiResponse(WeatherService weatherService) {
        weatherService.getWeather("Spain", "78cdd6cc085280fb04d306ff292448ca").enqueue(new Callback<WeatherInfoWrapper>() {
            @Override
            public void onResponse(Call<WeatherInfoWrapper> call, Response<WeatherInfoWrapper> response) {
                System.out.println("yes");
            }

            @Override
            public void onFailure(Call<WeatherInfoWrapper> call, Throwable t) {
                System.out.println("no");
            }
        });
    }


}
