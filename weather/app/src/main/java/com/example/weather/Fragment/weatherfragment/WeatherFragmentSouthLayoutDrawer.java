package com.example.weather.Fragment.weatherfragment;

        import android.view.View;

        import androidx.constraintlayout.widget.ConstraintLayout;
        import androidx.recyclerview.widget.LinearLayoutManager;
        import androidx.recyclerview.widget.RecyclerView;

        import com.example.weather.Adapter.RecycleViewAdapter;
        import com.example.weather.R;
        import com.example.weather.weather.CityWeather;

public class WeatherFragmentSouthLayoutDrawer {
    private RecyclerView recyclerView;
    private CityWeather cityWeather;
    public WeatherFragmentSouthLayoutDrawer(View view, CityWeather cityWeather) {
        recyclerView = getSouthWindowRecycler(view);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        this.cityWeather = cityWeather;
    }
    private RecyclerView getSouthWindowRecycler(View view) {
        ConstraintLayout northLayout = view.findViewById(R.id.wrapper);
        ConstraintLayout northLayoutMainFragment = northLayout.findViewById(R.id.main_fragment);
        ConstraintLayout forecast_window = northLayoutMainFragment.findViewById(R.id.recyler_view);
        return forecast_window.findViewById(R.id.activity_main_recycler_view);
    }
    public void draw() {
        RecycleViewAdapter recycleViewAdapter = new RecycleViewAdapter();
        recyclerView.setAdapter(recycleViewAdapter);
        recycleViewAdapter.setData(cityWeather.getList());
    }
}
