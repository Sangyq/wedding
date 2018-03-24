package com.wedding.app.service;

import com.wedding.app.dto.WeatherDataResponse;

/**
 * Created by sangyuqi on 2018/3/22.
 */
public interface IWeatherService {
    /**
     * 通过城市name获取天气
     * @param cityName
     * @return
     */
    WeatherDataResponse queryWeatherByCityName(String cityName);

    /**
     * 通过城市ID获取天气数据
     * @param cityKey
     * @return
     */
    WeatherDataResponse queryWeatherByCityKey(String cityKey);

    /**
     * 同步天气数据，写入redis
     * @param cityId
     */
    void syncDataByCityID(String cityId);
}
