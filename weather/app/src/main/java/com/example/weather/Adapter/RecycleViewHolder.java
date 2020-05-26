package com.example.weather.Adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.weather.R;
import com.example.weather.utils.DateUtils;
import com.example.weather.weather.WeatherInfo;
import com.squareup.picasso.Picasso;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class RecycleViewHolder extends RecyclerView.ViewHolder {
    private TextView time;
    private TextView temperature;
    private ImageView icon;
    public RecycleViewHolder(@NonNull View itemView) {
        super(itemView);
        time = itemView.findViewById(R.id.time);
        temperature = itemView.findViewById(R.id.temp);
        icon = itemView.findViewById(R.id.activity_weather_by_time_icon);
    }

    public void setData(WeatherInfo info) throws ParseException {
        setTime(info);
        setTemperature(info);
        setIcon(info);
    }

    private void setIcon(WeatherInfo info) {
        String iconId = info.getWeather().get(0).getIcon();
        Picasso.get().
                load("https://openweathermap.org/img/wn/"+iconId+"@2x.png").into(icon);
    }

    private void setTime(WeatherInfo info) throws ParseException {
        String string = info.getTemperatureDate();
        DateFormat format = new SimpleDateFormat("yyyy-M-dd hh:mm:ss", Locale.ENGLISH);
        Date date = format.parse(string);
        String result = DateUtils.parseDateToHoursAndMinutes(date, "MMMM-dd hh:mm");
        time.setText(result);
    }

    private void setTemperature(WeatherInfo info) {
        String tempStr = info.getTemperatureInfo().getTemp();
        double temp = Double.parseDouble(tempStr);
        temperature.setText((int)temp + " C");
    }
}
