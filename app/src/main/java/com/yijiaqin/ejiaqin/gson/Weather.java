package com.yijiaqin.ejiaqin.gson;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by yy on 2017/11/11.
 */

public class Weather {
    public String status;
    public Basic basic;
    public AQI aqi;
    public Now now;
    public Suggestion suggestion;

    @SerializedName("daily_forecast")
    public List<Forecast> forecastList;
}
