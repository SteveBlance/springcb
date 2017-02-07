package com.codaconsultancy.config;

import com.codaconsultancy.controller.PerformanceInterceptor;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.codaconsultancy.controller",
        "com.codaconsultancy.service"})
public class AppConfig extends WebMvcConfigurerAdapter {

    // declare Tiles configuration file
    @Bean
    public TilesConfigurer tilesConfigurer() {
        TilesConfigurer tilesConfigurer = new TilesConfigurer();
        final String[] definitions = {"/WEB-INF/tiles.xml"};
        tilesConfigurer.setDefinitions(definitions);
        return tilesConfigurer;
    }

    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:/messages");
        messageSource.setUseCodeAsDefaultMessage(true);
        return messageSource;
    }

    // declare Tiles as a view resolver
    @Bean
    public ViewResolver tilesViewResolver() {
        return new TilesViewResolver();
    }

    @Bean
    public HandlerInterceptor performanceInterceptor() {
        PerformanceInterceptor interceptor;
        interceptor = new PerformanceInterceptor();
        return interceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(performanceInterceptor()).addPathPatterns("/home", "/user/*");
    }
}


