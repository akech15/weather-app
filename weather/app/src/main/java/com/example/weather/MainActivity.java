package com.example.weather;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.weather.country.Country;
import com.example.weather.integration.countries.CountriesService;
import com.example.weather.integration.countries.CountriesServiceParams;
import com.example.weather.utils.retrofit.RetrofitHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import pl.droidsonroids.gif.GifImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private Button tryAgainBut;
    private GifImageView gifImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tryAgainBut = findViewById(R.id.try_again);
        gifImageView = findViewById(R.id.main_activity_loading_gif);
        getCountriesFromServer();
    }

    private void getCountriesFromServer() {
        gifImageView.setVisibility(View.VISIBLE);
        CountriesService countriesService = RetrofitHelper.getCountriesService(CountriesServiceParams.URL);
        downloadCountryNames(countriesService);
    }

    private void downloadCountryNames(CountriesService countriesService) {
        countriesService.getCountries().enqueue(new Callback<List<Country>>() {

            @Override
            public void onResponse(Call<List<Country>> call, Response<List<Country>> response) {
                if (response.isSuccessful()) {
                    gifImageView.setVisibility(View.INVISIBLE);
                    List<Country> list = response.body();
                    List<String> result = getCountryNames(list);
                    Intent in = new Intent(MainActivity.this, WeatherActivity.class);
                    in.putStringArrayListExtra("countries", (ArrayList<String>) result);
                    startActivity(in);
                } else {
                    tryAgainButtonAction();
                }
            }

            @Override
            public void onFailure(Call<List<Country>> call, Throwable t) {
                tryAgainButtonAction();
            }
        });
    }

    private List<String> getCountryNames(List<Country> list) {
        return list.stream().map(Country::getName).collect(Collectors.toList());
    }

    private void tryAgainButtonAction() {
        tryAgainBut.setVisibility(View.VISIBLE);
        gifImageView.setVisibility(View.INVISIBLE);
        tryAgainBut.setOnClickListener(v -> getCountriesFromServer());
    }

}
