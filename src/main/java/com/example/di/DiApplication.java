package com.example.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
public class DiApplication {
    @Autowired
    ContentProvider contentProvider;

    public static void main(String[] args) {
        SpringApplication.run(DiApplication.class, args);
    }

}
