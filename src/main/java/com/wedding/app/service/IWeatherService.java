package com.wedding.app.service;

import com.wedding.app.dto.WeatherDataResponse;

/**
 * Created by sangyuqi on 2018/3/22.
 */
public interface IWeatherService {
    WeatherDataResponse queryWeatherByCityName(String cityName);
    WeatherDataResponse queryWeatherByCityKey(String cityKey);
}
