package com.codaconsultancy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/list")
    public void userList(Model model) {
        model.addAttribute("nbUsers", 13);
    }

    @RequestMapping("/friends")
    public String userFriends() {
        return "my_friends";
    }

    @RequestMapping("/{id}/{field}")
    public void showUserField(@PathVariable("id") Long userId, @PathVariable("field") String field) {
        //todo: implement showUserField
    }

    @RequestMapping("/add")
    public void addUser() {
        //todo: implement addUser
    }
}
