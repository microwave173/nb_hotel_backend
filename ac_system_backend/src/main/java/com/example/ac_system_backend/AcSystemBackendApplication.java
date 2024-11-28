package com.example.ac_system_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@EnableScheduling
public class AcSystemBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(AcSystemBackendApplication.class, args);
    }

}
