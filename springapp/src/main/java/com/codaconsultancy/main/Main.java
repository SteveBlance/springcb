package com.codaconsultancy.main;

import com.codaconsultancy.config.AppConfig;
import com.codaconsultancy.entities.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext springContext = new AnnotationConfigApplicationContext(AppConfig.class);

        User admin = (User) springContext.getBean("admin");

        System.out.println("admin name: " + admin.getName());
        System.out.println("admin skill: " + admin.getSkill());

        springContext.close();
    }
}
