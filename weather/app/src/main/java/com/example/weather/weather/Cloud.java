package com.example.weather.weather;

import com.google.gson.annotations.SerializedName;

public class Cloud {

    @SerializedName("all")
    private int precipitation;

    public int getPrecipitation() {
        return precipitation;
    }

    public void setPrecipitation(int precipitation) {
        this.precipitation = precipitation;
    }
}
