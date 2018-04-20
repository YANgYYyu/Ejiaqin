package com.yijiaqin.ejiaqin.util;

import android.text.format.DateUtils;

import org.litepal.util.LogUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by 平塔岛象龟
 * 2018/4/9.
 */

public class TimeUtil {
    public static  String getTime(int distanceDay){
        SimpleDateFormat dft = new SimpleDateFormat("MM-dd HH:mm:ss");
        Date beginDate = new Date();
        Calendar date = Calendar.getInstance();
        date.setTime(beginDate);
        date.set(Calendar.DATE, date.get(Calendar.DATE) + distanceDay);
        Date endDate = null;
        try {
            endDate = dft.parse(dft.format(date.getTime()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dft.format(endDate);
    }
 }
