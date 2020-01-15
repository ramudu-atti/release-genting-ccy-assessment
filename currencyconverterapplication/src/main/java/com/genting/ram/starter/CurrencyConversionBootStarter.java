package com.genting.ram.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({ "com.genting.ram.starter", "com.genting.ram.dao","com.genting.ram.dao.impl","com.genting.ram.endpoints", "com.genting.ram.entity",
		 "com.genting.ram.config" })
@EnableJpaRepositories("com.genting.ram.dao")
@EntityScan("com.genting.ram.entity")
public class CurrencyConversionBootStarter {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyConversionBootStarter.class, args);

	}

}
