package com.example.weather.utils;

import android.icu.text.SimpleDateFormat;

import com.example.weather.weather.CityWeather;

import org.jetbrains.annotations.NotNull;

import java.util.Date;

public class DateUtils {

    public static boolean isNight() {
        return false;
    }

    public static String format(Date date, String pattern) {
        return parseDateToHoursAndMinutes(date, pattern);
    }


    private static String parseDateToHoursAndMinutes(Date date, String pattern) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        return simpleDateFormat.format(date);
    }
    @NotNull
    public static String getDayAndNightDateStr(CityWeather cityWeather) {
        Date sunrise = new Date(cityWeather.getCity().getSunrise());
        Date sunset = new Date(cityWeather.getCity().getSunset());
        return DateUtils.format(sunrise, "hh:mm aa") +
                DateUtils.format(sunset, "hh:mm aa");
    }

}
