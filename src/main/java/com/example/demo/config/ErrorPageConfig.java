package com.example.demo.config;

import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.ErrorPageRegistrar;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

@Configuration
public class ErrorPageConfig {

    @Bean
    public ErrorPageRegistrar errorPageRegistrar() {
        return registry -> {
            registry.addErrorPages(
                    new ErrorPage(HttpStatus.NOT_FOUND, "/404"),  // 404 오류 처리
                    new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/500")  // 500 오류 처리
            );
        };
    }
}
