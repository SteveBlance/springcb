package com.codaconsultancy.config;

import com.codaconsultancy.entities.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public User admin() {
        User user = new User();
        user.setName("Merlin");
        user.setSkill("Magic");
        return user;
    }
}
