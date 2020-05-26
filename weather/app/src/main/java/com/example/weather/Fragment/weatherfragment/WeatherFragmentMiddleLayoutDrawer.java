package com.example.weather.Fragment.weatherfragment;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.weather.R;
import com.example.weather.utils.DateUtils;
import com.example.weather.utils.Utilities;
import com.example.weather.weather.CityWeather;


public class WeatherFragmentMiddleLayoutDrawer {
    private ConstraintLayout middleWindowLayout;
    private String humidity;
    private int precipitation;
    private String windSpeed;
    private String dayAndNightDateStr;
    public WeatherFragmentMiddleLayoutDrawer(View view, CityWeather cityWeather){
        middleWindowLayout = getMiddleLayout(view);
        dayAndNightDateStr = DateUtils.getDayAndNightDateStr(cityWeather);
        windSpeed = cityWeather.getList().get(0).getWind().getSpeed();
        humidity = cityWeather.getList().get(0).getTemperatureInfo().getHumidity();
        precipitation = cityWeather.getList().get(0).getCloud().getPrecipitation();
    }

    private ConstraintLayout getMiddleLayout(View view) {
        ConstraintLayout northLayout = view.findViewById(R.id.wrapper);
        ConstraintLayout northLayoutMainFragment = northLayout.findViewById(R.id.main_fragment);
        ConstraintLayout description_window = northLayoutMainFragment.findViewById(R.id.description_layout);
        return description_window.findViewById(R.id.include_description);
    }

    private void setHumidity(){
        Integer humidityIcon = Utilities.getOrElse(DateUtils.isNight(), R.drawable.ic_humidity_night, R.drawable.ic_humidity);
        ConstraintLayout humidityLayout = middleWindowLayout.findViewById(R.id.humidity);
        TextView descName = humidityLayout.findViewById(R.id.desc_name);
        descName.setText(R.string.humidity);
        TextView value = humidityLayout.findViewById(R.id.value);
        value.setText(humidity + "%");
        ImageView icon = humidityLayout.findViewById(R.id.icon);
        icon.setImageResource(humidityIcon);

    }
    private void setPrecipitation(){
        Integer precipitationIcon = Utilities.getOrElse(DateUtils.isNight(), R.drawable.ic_drop_night, R.drawable.ic_drop);
        ConstraintLayout PrecipitationLayout = middleWindowLayout.findViewById(R.id.precipitation);
        TextView descName = PrecipitationLayout.findViewById(R.id.desc_name);
        descName.setText(R.string.precipitation);
        TextView value = PrecipitationLayout.findViewById(R.id.value);
        value.setText(precipitation + "%");
        ImageView icon = PrecipitationLayout.findViewById(R.id.icon);
        icon.setImageResource(precipitationIcon);
    }
    private void setWindSpeed(){
        Integer windSpeedIcon = Utilities.getOrElse(DateUtils.isNight(), R.drawable.ic_flag_night, R.drawable.ic_flag);
        ConstraintLayout windSpeedLayout = middleWindowLayout.findViewById(R.id.wind_speed);
        TextView descName = windSpeedLayout.findViewById(R.id.desc_name);
        descName.setText(R.string.wind_speed);
        TextView value = windSpeedLayout.findViewById(R.id.value);
        value.setText(windSpeed + "kmh");
        ImageView icon = windSpeedLayout.findViewById(R.id.icon);
        icon.setImageResource(windSpeedIcon);
    }
    private void setDayAndNight(){
        Integer dayAndNightIcon = R.drawable.ic_day_night;
        ConstraintLayout dayAndNightLayout = middleWindowLayout.findViewById(R.id.day_and_night);
        TextView descName = dayAndNightLayout.findViewById(R.id.desc_name);
        descName.setText(R.string.day_and_night);
        TextView value = dayAndNightLayout.findViewById(R.id.value);
        value.setText(dayAndNightDateStr);
        ImageView icon = dayAndNightLayout.findViewById(R.id.icon);
        icon.setImageResource(dayAndNightIcon);
    }

    public void draw(){
        setHumidity();
        setDayAndNight();
        setWindSpeed();
        setPrecipitation();
    }

}
