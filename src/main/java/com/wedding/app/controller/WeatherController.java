package com.wedding.app.controller;

import com.wedding.app.dto.WeatherDataResponse;
import com.wedding.app.service.IWeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by sangyuqi on 2018/3/22.
 */
@RestController
@RequestMapping("/weather")
public class WeatherController {

    @Autowired
    private IWeatherService weatherService;

    @GetMapping("/cityName/{cityName}")
    public WeatherDataResponse queryWeatherByCityName(@PathVariable String city){
        return weatherService.queryWeatherByCityName(city);
    }

    @GetMapping("/cityKey/{cityKey}")
    public WeatherDataResponse queryWeatherByCityKey(@PathVariable String cityKey){
        return weatherService.queryWeatherByCityKey(cityKey);
    }

}
