package com.epam.lab.payments;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class Payments {
    public static void main(String[] args) {
        SpringApplication.run(Payments.class , args);
    }
}
