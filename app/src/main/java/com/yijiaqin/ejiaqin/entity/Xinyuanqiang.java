package com.yijiaqin.ejiaqin.entity;

import org.litepal.crud.DataSupport;

/**
 * 作者：平塔岛象龟
 *
 * 邮箱：454941261@qq.com
 *
 * 创建日期：2018/4/10
 *
 * 文件描述:心愿墙的实体类，通过litepal存储到数据库里
 *
 * 备注:
 */

public class Xinyuanqiang extends DataSupport {
    private String content;
    private String time;

    public Xinyuanqiang() {
    }
    public Xinyuanqiang(String content, String time) {
        this.content = content;
        this.time = time;
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


}
