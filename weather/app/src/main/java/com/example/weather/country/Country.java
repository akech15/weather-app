package com.example.weather.country;

import com.google.gson.annotations.SerializedName;

public class Country {
    @SerializedName("name")
    private String name;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
