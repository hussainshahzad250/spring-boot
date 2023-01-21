package com.sas.cache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class SpringHazlecastApplication {

    public static void main(String[] args) {
		SpringApplication.run(SpringHazlecastApplication.class, args);
    }
}
