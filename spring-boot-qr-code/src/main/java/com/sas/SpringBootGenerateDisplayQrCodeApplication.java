package com.sas;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class SpringBootGenerateDisplayQrCodeApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootGenerateDisplayQrCodeApplication.class, args);
        log.info("Application started successfully");
    }

}
