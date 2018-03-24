package com.wedding.app.service.impl;

import com.wedding.app.dto.City;
import com.wedding.app.dto.CityList;
import com.wedding.app.service.ICityDataService;
import com.wedding.utils.XmlToBean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

/**
 * Created by sangyuqi on 2018/3/24.
 */
@Service
public class CityDataServiceImpl implements ICityDataService {
    @Override
    public List<City> cityList() throws Exception {
        Resource resource = new ClassPathResource("citylist.xml");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(resource.getInputStream(),"Utf-8"));
        StringBuffer stringBuffer = new StringBuffer();
        String line = "";
        while((line = bufferedReader.readLine())!=null){
            stringBuffer.append(line);
        }
        bufferedReader.close();
        CityList cityList = (CityList) XmlToBean.xmlStrToObject(CityList.class,stringBuffer.toString());
        return cityList.getCityList();
    }
}
