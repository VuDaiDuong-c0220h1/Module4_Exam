package com.codegym.exam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class ExamApplication implements WebMvcConfigurer {

    public static void main(String[] args) {
        SpringApplication.run(ExamApplication.class, args);
    }

}
