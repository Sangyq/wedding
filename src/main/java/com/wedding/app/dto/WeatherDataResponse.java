package com.wedding.app.dto;

import java.io.Serializable;

/**
 * Created by sangyuqi on 2018/3/22.
 */
public class WeatherDataResponse implements Serializable{

    private WeatherData data;
    private String status;
    private String desc;

    public WeatherData getData() {
        return data;
    }

    public void setData(WeatherData data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "WeatherDataResponse{" +
                "data=" + data +
                ", status='" + status + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}
