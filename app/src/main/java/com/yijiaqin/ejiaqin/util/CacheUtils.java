package com.yijiaqin.ejiaqin.util;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * 通过SharedPreference缓存数据
 * Created by Administrator on 2017/8/6.
 */
//// TODO: 2017/10/5 commit()可用apply()代替 
public class CacheUtils {

    private static final String CONFIG_SP = "config_sp"; //config_sp.xml文件  位置是:/data/dat/<包名>/shared_prefes
    public static final String PIC_URI = "pic_uri";

    private static SharedPreferences mSp;

    private static SharedPreferences getPreferences(Context context) {
        if (mSp == null) {
            mSp = context.getSharedPreferences(CONFIG_SP, Context.MODE_PRIVATE);
        }
        return mSp;
    }

    //保存布尔数据
    public static void putBoolean(Context context, String key, boolean value) {
        SharedPreferences sp = getPreferences(context);
        sp.edit().putBoolean(key, value).commit();
    }

    //取布尔数据  默认返回false
    public static Boolean getBoolean(Context context, String key) {
        SharedPreferences sp = getPreferences(context);
        return sp.getBoolean(key, false);
    }

    //取布尔数据  返回传递过来的值
    public static Boolean getBoolean(Context context, String key, Boolean defValue) {
        SharedPreferences sp = getPreferences(context);
        return sp.getBoolean(key, defValue);
    }

    //保存字符串数据
    public static void putString(Context context, String key, String value) {
        SharedPreferences sp = getPreferences(context);
        sp.edit().putString(key, value).commit();
    }

    //取字符串数据  默认返回 null
    public static String getString(Context context, String key) {
        SharedPreferences sp = getPreferences(context);
        return sp.getString(key, null);
    }

    //取字符串数据  返回传过来的值
    public static String getString(Context context, String key, String defValue) {
        SharedPreferences sp = getPreferences(context);
        return sp.getString(key, defValue);
    }


    //保存整数
    public static void putInt(Context context, String key, int value) {
        SharedPreferences sp = getPreferences(context);
        sp.edit().putInt(key, value).commit();
    }

    //取整数  默认返回 0
    public static int getInt(Context context, String key) {
        SharedPreferences sp = getPreferences(context);
        return sp.getInt(key, 0);
    }

    //取整数  返回传过来的值
    public static int getInt(Context context, String key, int defValue) {
        SharedPreferences sp = getPreferences(context);
        return sp.getInt(key, defValue);
    }

}
