package com.yijiaqin.ejiaqin.entity;

/**
 * Created by 平塔岛象龟
 * 2018/4/2.
 */

public class Food {
    private String title;
    private String material;

    public Food() {

    }

    public Food(String title, String material) {
        this.title = title;
        this.material = material;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getmaterial() {
        return material;
    }

    public void setmaterial(String material) {
        this.material = material;
    }
}
