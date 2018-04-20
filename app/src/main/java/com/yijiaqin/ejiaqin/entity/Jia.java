package com.yijiaqin.ejiaqin.entity;

import java.security.Principal;

/**
 * Created by 平塔岛象龟
 * 2018/4/8.
 */

public class Jia {
    private int imageView;
    private String title;
    private String location;
    private String bed;
    private String cost;

    public Jia(int imageView, String title, String location, String bed, String cost) {
        this.imageView = imageView;
        this.title = title;
        this.location = location;
        this.bed = bed;
        this.cost = cost;
    }

    public Jia() {
    }

    public int getImageView() {
        return imageView;
    }

    public void setImageView(int imageView) {
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

    public String getBed() {
        return bed;
    }

    public void setBed(String bed) {
        this.bed = bed;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }
}
