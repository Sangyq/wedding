package com.wedding.app.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by sangyuqi on 2018/3/21.
 */
@RestController
public class BaseController {

    @RequestMapping(value = "/index",method = RequestMethod.GET)
    @ResponseBody
    public String init(){
        return "hello world";
    }

    @RequestMapping(value = "/login",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public String login(){
        return "请先登录";
    }

}
