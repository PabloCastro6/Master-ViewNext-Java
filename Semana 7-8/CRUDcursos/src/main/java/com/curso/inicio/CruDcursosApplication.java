package com.curso.inicio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages = {"com.curso.controller", "com.curso.service", "com.curso.model"})
public class CruDcursosApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruDcursosApplication.class, args);
	}

}
