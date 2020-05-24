package com.example.weather.integration.countries;

import com.example.weather.country.Country;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CountriesService {
    @GET("all")
    Call<List<Country>> getCountries();
}
