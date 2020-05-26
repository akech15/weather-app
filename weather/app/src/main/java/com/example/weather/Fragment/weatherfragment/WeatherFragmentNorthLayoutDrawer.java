package com.example.weather.Fragment.weatherfragment;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.weather.R;
import com.example.weather.utils.DateUtils;
import com.example.weather.utils.Utilities;
import com.example.weather.weather.CityWeather;

public class WeatherFragmentNorthLayoutDrawer {

    private ConstraintLayout northWindowLayout;

    private final String temperature;
    private final String feelsLike;
    private String country;

    public WeatherFragmentNorthLayoutDrawer(View view, CityWeather cityWeather, String country) {
        northWindowLayout = getNorthWindowLayout(view);
        temperature = cityWeather.getList().get(0).getTemperatureInfo().getTemp();
        feelsLike = cityWeather.getList().get(0).getTemperatureInfo().getFeelsLike();
        this.country = country;
    }

    private ConstraintLayout getNorthWindowLayout(View view) {
        ConstraintLayout northLayout = view.findViewById(R.id.wrapper);
        ConstraintLayout northLayoutMainFragment = northLayout.findViewById(R.id.main_fragment);
        ConstraintLayout forecast_window = northLayoutMainFragment.findViewById(R.id.main_forecast_window);
        return forecast_window.findViewById(R.id.include_forecast);
    }

    private void setBackgroundColorAndIcon() {
        Integer backgroundDrawableId = Utilities.getOrElse(DateUtils.isNight(), R.drawable.background_night, R.drawable.background_day);
        Integer iconMoonOrSunImageResourceId = Utilities.getOrElse(DateUtils.isNight(), R.drawable.ic_moon, R.drawable.ic_sun);
        ImageView dayOrNightIcon = northWindowLayout.findViewById(R.id.dayOrNight_icon);
        Drawable background = northWindowLayout.getContext().getDrawable(backgroundDrawableId);
        northWindowLayout.setBackground(background);
        dayOrNightIcon.setImageResource(iconMoonOrSunImageResourceId);
    }

    private void setCountryName(String country) {
        TextView cityName = northWindowLayout.findViewById(R.id.country_name);
        cityName.setText(country);
    }

    private void setTemperature(String temperature) {
        TextView temp = northWindowLayout.findViewById(R.id.city_temperature);
        double tempDouble = Double.parseDouble(temperature);
        temp.setText(((int) tempDouble) + " C");
    }

    private void setFeelsLike(String temperature) {
        TextView temp = northWindowLayout.findViewById(R.id.percieved);
        double tempDouble = Double.parseDouble(temperature);
        temp.setText("Perceived " + (int) tempDouble + " C");
    }

    public void draw() {
        setCountryName(country);
        setFeelsLike(feelsLike);
        setTemperature(temperature);


        setBackgroundColorAndIcon();
    }
}
