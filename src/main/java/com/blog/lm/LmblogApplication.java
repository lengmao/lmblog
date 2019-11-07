package com.blog.lm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@SpringBootApplication
public class LmblogApplication {

    public static void main(String[] args) {
        SpringApplication.run(LmblogApplication.class, args);
    }

}
