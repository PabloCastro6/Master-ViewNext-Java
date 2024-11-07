package com.agencia.hoteles.principal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;


@EntityScan(basePackages="com.agencia.hoteles.model")
@EnableJpaRepositories(basePackages="com.agencia.hoteles.repository")
@SpringBootApplication(scanBasePackages = {"com.agencia.hoteles.controller", "com.agencia.hoteles.service"})
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
