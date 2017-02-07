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

    @RequestMapping("/home")
    public String home() {
        return "main_home";
    }

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

    @RequestMapping("beans")
    @ResponseBody
    public String listBeanNames() {
        StringBuilder beanNames = new StringBuilder("Beans:\n");
        String[] beans = applicationContext.getBeanDefinitionNames();
        for (String bean : beans) {
            beanNames.append(bean).append("\n");
        }
        return toHtml(beanNames.toString());
    }

    private String toHtml(String pageText) {
        StringBuilder html = new StringBuilder("<html><head></head><body><p>");
        html.append(pageText);
        html.append("</p></body></html>");
        return html.toString().replace("\n", "<br />");
    }
}
