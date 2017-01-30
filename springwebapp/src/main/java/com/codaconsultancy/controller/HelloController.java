package com.codaconsultancy.controller;

import com.codaconsultancy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @Autowired
    UserService userService;

    @Autowired
    ApplicationContext applicationContext;

    @RequestMapping("hi")
    @ResponseBody
    public String hi() {
        return "nb of users: " + userService.findNumberOfUsers();
    }

    @RequestMapping("hello")
    @ResponseBody
    public String hello() {
        UserService userService = (UserService) applicationContext.getBean("userService");
        return "nm of users: " + userService.findNumberOfUsers();
    }
}
