package com.example.android.temperatureconverter.model;

/**
 * Created by hernandez on 12/3/2015.
 */
public class convertTemp {

    private int mCelsius;
    private int mFahrenheit;

    public int convertToCelsius(int fahrenheit){
        mCelsius = ((fahrenheit-32)*5)/9;
        return mCelsius;
    }

    public int convertToFahrenheit(int celsius){
        mFahrenheit  = ((celsius*9)/5)+32;
        return mFahrenheit;
    }

}
