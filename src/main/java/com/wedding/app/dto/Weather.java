package com.wedding.app.dto;

import java.io.Serializable;

/**
 * Created by sangyuqi on 2018/3/22.
 */
public class Weather implements Serializable{
    private String date;
    private String hight;
    private String fx;
    private String fow;
    private String fl;
    private String type;
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHight() {
        return hight;
    }

    public void setHight(String hight) {
        this.hight = hight;
    }

    public String getFx() {
        return fx;
    }

    public void setFx(String fx) {
        this.fx = fx;
    }

    public String getFow() {
        return fow;
    }

    public void setFow(String fow) {
        this.fow = fow;
    }

    public String getFl() {
        return fl;
    }

    public void setFl(String fl) {
        this.fl = fl;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "date='" + date + '\'' +
                ", hight='" + hight + '\'' +
                ", fx='" + fx + '\'' +
                ", fow='" + fow + '\'' +
                ", fl='" + fl + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
