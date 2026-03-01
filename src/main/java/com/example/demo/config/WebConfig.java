package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**")
                .allowedOrigins("https://demofejamlien17march1.azurestaticapps.net") // URL Frontend sau khi deploy
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowCredentials(true);
    }
} 
