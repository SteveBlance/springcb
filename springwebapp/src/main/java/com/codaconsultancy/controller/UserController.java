package com.codaconsultancy.controller;

import com.codaconsultancy.repository.User;
import com.codaconsultancy.repository.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserDAO userDAO;

    @RequestMapping("/list")
    public String userList(Model model) {
        int size = userDAO.findAll().size();
        model.addAttribute("nbUsers", size);
        return "main_user/list";
    }

    @RequestMapping("/friends")
    public String userFriends() {
        return "secondary_my_friends";
    }

    @RequestMapping("/{id}/{field}")
    public void showUserField(@PathVariable("id") Long userId, @PathVariable("field") String field) {
        //todo: implement showUserField
    }

    @RequestMapping("/add/{firstName}/{age}")
    @ResponseBody
    public String add(@PathVariable("firstName") String firstName, @PathVariable("age") Integer age) {
        User user = new User(firstName, age);
        userDAO.add(user);
        return "User " + firstName + " : " + age;
    }

}
