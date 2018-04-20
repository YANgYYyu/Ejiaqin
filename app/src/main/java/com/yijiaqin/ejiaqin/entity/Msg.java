package com.yijiaqin.ejiaqin.entity;

/**
 * 作者：平塔岛象龟
 *
 * 邮箱：454941261@qq.com
 *
 * 创建日期：2018/4/9
 *
 * 文件描述:消息的实体类
 *
 * 备注:
 */

public class Msg {
    public static final int TYPE_RECEIVER = 0;
    public static final int TYPE_SEND = 1;
    private int imageView;
    private String content;
    private String time;
    private String name;
    private int type;   //消息的类型，可选的值即为上面的两个常量

    public Msg( int imageView, String content, String time, String name, int type) {
        this.imageView = imageView;
        this.content = content;
        this.time = time;
        this.name = name;
        this.type = type;
    }

    public int getImageView() {
        return imageView;
    }

    public void setImageView(int imageView) {
        this.imageView = imageView;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
