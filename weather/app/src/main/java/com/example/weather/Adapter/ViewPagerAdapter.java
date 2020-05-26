package com.example.weather.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.weather.Fragment.weatherfragment.WeatherFragment;

import java.util.List;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private List<String> countries;

    public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior, List<String> countries) {
        super(fm, behavior);
        this.countries = countries;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        String country = countries.get(position);
        return WeatherFragment.newInstance(country);
    }

    @Override
    public int getCount() {
        return countries.size();
    }
}
