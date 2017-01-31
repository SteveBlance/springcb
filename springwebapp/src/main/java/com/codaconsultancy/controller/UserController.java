package com.codaconsultancy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    @RequestMapping("/user/list")
    public void userList() {
    }

    @RequestMapping("/user/friends")
    public String userFriends() {
        return "my_friends";
    }
}
