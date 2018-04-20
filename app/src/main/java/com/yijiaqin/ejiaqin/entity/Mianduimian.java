package com.yijiaqin.ejiaqin.entity;

/**
 * 作者：平塔岛象龟
 *
 * 邮箱：454941261@qq.com
 *
 * 创建日期：2018/4/9
 *
 * 文件描述:面对面那个fragment的实体类
 *
 * 备注:
 */

public class Mianduimian {

    private int imageView;
    private String name;
    private String content;
    private String time;

    public int getImageView() {
        return imageView;
    }

    public void setImageView(int imageView) {
        this.imageView = imageView;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Mianduimian() {

    }

    public Mianduimian(int imageView, String name, String content, String time) {

        this.imageView = imageView;
        this.name = name;
        this.content = content;
        this.time = time;
    }

}
