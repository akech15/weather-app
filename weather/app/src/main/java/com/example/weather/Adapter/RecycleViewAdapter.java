package com.example.weather.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.weather.R;
import com.example.weather.weather.WeatherInfo;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<WeatherInfo> weatherInfo = new ArrayList<>();

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_weather_by_time, parent, false);
        return new RecycleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
            WeatherInfo info = weatherInfo.get(position);
            if (holder instanceof RecycleViewHolder){
                RecycleViewHolder recycleViewHolder = (RecycleViewHolder) holder;
                try {
                    recycleViewHolder.setData(info);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
    }

    @Override
    public int getItemCount() {
        return weatherInfo.size();
    }

    public void setData(List<WeatherInfo> list) {
        weatherInfo.clear();
        weatherInfo.addAll(list);
        notifyDataSetChanged();
    }
}
