package com.codaconsultancy.controller;

import com.codaconsultancy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @Autowired
    UserService userService;

    @RequestMapping("hi")
    @ResponseBody
    public String hi() {
        return "nb of users: " + userService.findNumberOfUsers();
    }
}
