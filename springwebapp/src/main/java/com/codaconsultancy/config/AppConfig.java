package com.codaconsultancy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.codaconsultancy.controller",
        "com.codaconsultancy.service"})
public class AppConfig {

    // declare Tiles configuration file
    @Bean
    public TilesConfigurer tilesConfigurer() {
        TilesConfigurer tilesConfigurer = new TilesConfigurer();
        final String[] definitions = {"/WEB-INF/tiles.xml"};
        tilesConfigurer.setDefinitions(definitions);
        return tilesConfigurer;
    }

    // declare Tiles as a view resolver
    @Bean
    public ViewResolver tilesViewResolver() {
        TilesViewResolver resolver = new TilesViewResolver();
        return resolver;
    }
}


