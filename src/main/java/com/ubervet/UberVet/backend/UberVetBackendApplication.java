package com.ubervet.UberVet.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
@ComponentScan("com.ubervet.UberVet.backend.service")
public class UberVetBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(UberVetBackendApplication.class, args);
	}
}
