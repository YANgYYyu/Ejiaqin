package com.yijiaqin.ejiaqin.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by yy on 2017/11/10.
 */

public class Basic {
    @SerializedName("city")
    public String cityName;

    @SerializedName("id")
    public String weatherId;

    public Update update;

    public class Update{
        @SerializedName("loc")
        public String updateTime;
    }
}
