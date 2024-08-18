package com.docker.project.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfiguration implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        String allowedOrigins = System.getenv("ALLOWED_ORIGINS"); // Fetch allowed origins from environment variable
        if (allowedOrigins == null || allowedOrigins.isEmpty()) {
            allowedOrigins = "*"; // Default to allow all origins if not set
        }

        registry.addMapping("/**")
                .allowedOrigins(allowedOrigins.split(",")) // Split comma-separated origins
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS");
    }
}
