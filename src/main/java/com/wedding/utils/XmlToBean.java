package com.wedding.utils;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.FileReader;
import java.io.Reader;
import java.io.StringReader;

/**
 * Xml To Bean
 * Created by sangyuqi on 2018/3/24.
 */
public class XmlToBean {

    public static  Object xmlStrToObject(Class<?> clazz,String xmlStr) throws Exception{
        Object xmlObject = null;
        Reader reader = null;
        JAXBContext context = JAXBContext.newInstance(clazz);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        reader = new StringReader(xmlStr);
        xmlObject = unmarshaller.unmarshal(reader);
        if(null!=reader){
            reader.close();
        }
        return xmlObject;
    }
}
