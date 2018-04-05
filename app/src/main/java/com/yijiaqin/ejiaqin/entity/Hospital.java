package com.yijiaqin.ejiaqin.entity;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

/**
 * Created by 平塔岛象龟
 * 2018/4/5.
 */

public class Hospital {
    private int imageView;
    private String title;
    private String location;

    public Hospital() {
    }

    public Hospital(int imageView, String title, String location) {
        this.imageView = imageView;
        this.title = title;
        this.location = location;
    }

    public int getimageView() {
        return imageView;
    }

    public void setimageView(int imageView) {
        this.imageView = imageView;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
