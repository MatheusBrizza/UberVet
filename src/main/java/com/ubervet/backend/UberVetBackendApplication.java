package com.ubervet.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class UberVetBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(UberVetBackendApplication.class, args);
    }
}
