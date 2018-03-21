package com.wedding.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by sangyuqi on 2018/3/21.
 */
@Controller
@RequestMapping(value = "/wedding")
public class BaseController {
    @RequestMapping(value = "/index",method = RequestMethod.GET,produces="application/json;charset=UTF-8")
    @ResponseBody
    public String init(){
        return "hello world";
    }

}
