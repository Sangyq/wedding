package com.wedding.app.controller;

import com.wedding.app.dto.User;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by sangyuqi on 2018/3/22.
 */
@Controller
public class LoginController {
    @RequestMapping(value = "/user/login",method = RequestMethod.POST)
    public boolean login(HttpServletRequest request,HttpServletResponse response,User user){

        return false;
    }
    @RequestMapping(value = "/user/regist",method = RequestMethod.POST)
    public boolean regist(HttpServletRequest request, HttpServletResponse response){
        return false;
    }
}
