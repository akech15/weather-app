package com.example.weather;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.weather.viewPagerAdapter.ViewPagerAdapter;

import java.util.List;

public class WeatherActivity extends AppCompatActivity {
    private ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        Intent intent = getIntent();
        List<String> countries = intent.getStringArrayListExtra("countries");
        viewPager = findViewById(R.id.view_pager);
        ViewPagerAdapter adapter = new ViewPagerAdapter(this.getSupportFragmentManager(),0, countries);
        viewPager.setAdapter(adapter);
    }




}
