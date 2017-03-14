package com.codaconsultancy.controller;

import com.codaconsultancy.repository.User;
import com.codaconsultancy.repository.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserDAO userDAO;

    @ModelAttribute("defaultUser")
    public User defaultUser() {
        User user = new User();
        user.setFirstName("Joe");
        user.setAge(18);
        return user;
    }

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

    @RequestMapping("/addUser")
    public String addUser() {
        return "main_user/add";
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public String addUserSubmit(HttpServletRequest request) {
        String firstName = request.getParameter("firstName");
        String ageString = request.getParameter("age");
        Integer age = Integer.parseInt(ageString);
        User user = new User(firstName, age);
        userDAO.add(user);
        return "redirect:/home";
    }

    @RequestMapping("/add/{firstName}/{age}")
    @ResponseBody
    public String add(@PathVariable("firstName") String firstName, @PathVariable("age") Integer age) {
        User user = new User(firstName, age);
        userDAO.add(user);
        return "User " + firstName + " : " + age;
    }

}
