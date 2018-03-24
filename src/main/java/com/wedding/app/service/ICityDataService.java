package com.wedding.app.service;

import com.wedding.app.dto.City;

import java.util.List;

/**
 * Created by sangyuqi on 2018/3/24.
 */
public interface ICityDataService {
    List<City> cityList()throws Exception;
}
