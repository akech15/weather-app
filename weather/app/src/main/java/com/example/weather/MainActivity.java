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

import java.util.List;

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
        getCountriesFromServer();
    }

    private void getCountriesFromServer() {
        CountriesService countriesService = RetrofitHelper.getCountriesService(CountriesServiceParams.URL);
        downloadCountryNames(countriesService);
    }

    private void downloadCountryNames(CountriesService countriesService) {
        countriesService.getCountries().enqueue(new Callback<List<Country>>() {

            @Override
            public void onResponse(Call<List<Country>> call, Response<List<Country>> response) {
                if (response.isSuccessful()) {
                    List<Country> list = response.body();
                    Intent in = new Intent(MainActivity.this, WeatherActivity.class);
//                    in.putExtra("countriesList", (Parcelable) list);
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

    private void tryAgainButtonAction() {
        tryAgainBut.setVisibility(View.VISIBLE);
        tryAgainBut.setOnClickListener(v -> getCountriesFromServer());
    }

}
