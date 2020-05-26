package com.example.weather.utils;

public class Utilities {

    public static <T> T getOrElse(boolean condition, T var1, T var2) {
        return condition ? var1 : var2;
    }

}
