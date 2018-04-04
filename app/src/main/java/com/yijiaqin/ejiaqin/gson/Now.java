package com.yijiaqin.ejiaqin.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by yy on 2017/11/11.
 */

public class Now {
    @SerializedName("tmp")
    public String temperature;

    @SerializedName("cond")
    public More more;
    public class More{
        @SerializedName("txt")
        public String info;
    }
}
