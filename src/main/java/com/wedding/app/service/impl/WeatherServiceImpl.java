package com.wedding.app.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wedding.app.dto.City;
import com.wedding.app.dto.WeatherDataResponse;
import com.wedding.app.service.BaseService;
import com.wedding.app.service.ICityDataService;
import com.wedding.app.service.IWeatherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;


/**
 * Created by sangyuqi on 2018/3/22.
 */
@Service
public class WeatherServiceImpl extends BaseService implements IWeatherService {

    private static final String url = "http://wthrcdn.etouch.cn/weather_mini?";

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    StringRedisTemplate redistemplate;

    @Autowired
    ICityDataService cityDataService;

    @Override
    public void syncDataByCityID(String cityId){
        String uri = url + "citykey=" +cityId;
       saveWeatherData(uri);
    }

    @Override
    public WeatherDataResponse queryWeatherByCityName(String cityName) {
        log.info("queryWeatherByCityName:{}",cityName);
        String uri = url + "city="+cityName;
        return this.getWeather(uri);
    }

    @Override
    public WeatherDataResponse queryWeatherByCityKey(String cityKey) {
        log.info("queryWeatherByCityKey:{}",cityKey);
        String uri = url + "citykey="+cityKey;
        return this.getWeather(uri);
    }

    private WeatherDataResponse getWeather(String uri){
        WeatherDataResponse response = null;
        String strBody = null;
        ValueOperations<String, String>  s = redistemplate.opsForValue();
        ObjectMapper mapper = new ObjectMapper();
        if(redistemplate.hasKey(uri)){
            log.info("走缓存");
            strBody = s.get(uri);
        }else {
            log.info("不走缓存");
            ResponseEntity<String> respString =  restTemplate.getForEntity(uri,String.class);
            log.info("respString:{}",respString);
            if(respString.getStatusCodeValue()==200){
                strBody = respString.getBody();
                s.set(uri,strBody,500);
            }
        }
        log.info("strBody:{}",strBody);
        try{
            response = mapper.readValue(strBody,WeatherDataResponse.class);
        }catch (Exception e){
            log.error(e.getMessage());
        }
        return response;
    }
    /**
     * 把天气数据存入缓存
     */
    private void saveWeatherData(String uri){
        String strBody = null;
        ValueOperations<String, String>  ops = redistemplate.opsForValue();
        ResponseEntity<String> respString =  restTemplate.getForEntity(uri,String.class);
        log.info("respString:{}",respString);
        if(respString.getStatusCodeValue()==200){
                strBody = respString.getBody();
        }
        ops.set(uri,strBody,1800, TimeUnit.SECONDS);
    }
}
