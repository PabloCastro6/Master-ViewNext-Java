package com.agencia.reservas.principal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;


@EntityScan(basePackages = "com.agencia.reservas.model")
@EnableJpaRepositories(basePackages = "com.agencia.reservas.repository")
@SpringBootApplication(scanBasePackages = {"com.agencia.reservas.controller", "com.agencia.reservas.service"})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    
    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
