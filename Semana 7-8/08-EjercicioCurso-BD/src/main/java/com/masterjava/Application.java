package com.masterjava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = "com.masterjava.model")
@EnableJpaRepositories(basePackages = "com.masterjava.repository")
@SpringBootApplication(scanBasePackages = { "com.masterjava.controller", "com.masterjava.service" })
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
