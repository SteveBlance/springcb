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

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/testschema");
        dataSource.setUsername("root");
        dataSource.setPassword("");

        return dataSource;
    }

}
