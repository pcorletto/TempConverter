package com.example.android.temperatureconverter.model;

/**
 * Created by hernandez on 12/3/2015.
 */
public class convertTemp {

    private float mCelsius;
    private float mFahrenheit;

    public float convertToCelsius(float fahrenheit){
        mCelsius = ((fahrenheit-32)*5)/9;
        return mCelsius;
    }

    public float convertToFahrenheit(float celsius){
        mFahrenheit  = ((celsius*9)/5)+32;
        return mFahrenheit;
    }

}
