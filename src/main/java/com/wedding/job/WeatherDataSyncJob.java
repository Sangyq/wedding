package com.wedding.job;

import com.wedding.app.dto.City;
import com.wedding.app.service.ICityDataService;
import com.wedding.app.service.IWeatherService;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Weather Data Sync Job
 * Created by sangyuqi on 2018/3/22.
 */
public class WeatherDataSyncJob extends QuartzJobBean {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    ICityDataService cityDataService;

    @Autowired
    IWeatherService weatherService;

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        List<City> cityList = new ArrayList<>();
        //获取程序列表
        try {
            cityList = cityDataService.cityList();
        }catch (Exception e){
            logger.error(e.getMessage());
        }
        //遍历城市列表，获取天气信息
        for(City city : cityList){
            logger.info("syncDataByCityID:{}",city.getCityId());
            weatherService.syncDataByCityID(city.getCityId());
        }
    }

}
