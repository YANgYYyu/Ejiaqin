package com.yijiaqin.ejiaqin.util;

import android.annotation.SuppressLint;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间戳转换成北京时间的工具类
 * Created by yy on 2017/11/20.
 */

public class DateUtil {
//    private static DateUtil instance;
//    private Context context;

//    private DateUtil(Context context) {
//        this.context = context;
//    }

//    //单例模式，在一个application生存周期中，该工具类只能被实例化一次
//    public static synchronized DateUtil getInstance(Context context) {
//        if (instance == null) {
//            instance = new DateUtil(context.getApplicationContext());   //传入context可能会造成内存泄漏，所以要调用getApplicationContext()，
//        }
//        return instance;
//    }



//    public static void main(String[] args) {
//        System.out.println(DateUtil.getStrTime(String.valueOf(System.currentTimeMillis())));
//        System.out.print(DateUtil.getTimeStamp((DateUtil.getStrTime(String.valueOf(System.currentTimeMillis())))));
//    }

    /**
     * 时间戳转为时间(年月日，时分秒)
     *
     * @param cc_time 时间戳
     * @return
     */
    public static String getStrTime(String cc_time) {
        String re_StrTime = null;
        //同理也可以转为其它样式的时间格式.例如："yyyy/MM/dd HH:mm"
        @SuppressLint("SimpleDateFormat")
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        // 例如：cc_time=1291778220
        long lcc_time = Long.valueOf(cc_time);
        re_StrTime = sdf.format(new Date(lcc_time ));

        return re_StrTime;
    }

    /**
     * 时间转换为时间戳
     *
     * @param timeStr 时间 例如: 2016-03-09
     * @return
     */
    public static long getTimeStamp(String timeStr) {
        @SuppressLint("SimpleDateFormat")
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        Date date = null;
        try {
            date = simpleDateFormat.parse(timeStr);
            return date.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
