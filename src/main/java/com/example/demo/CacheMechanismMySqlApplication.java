package com.example.demo;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

import com.example.runner.DataLoader;

@SpringBootApplication
@EnableCaching
public class CacheMechanismMySqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(CacheMechanismMySqlApplication.class, args);
	}
	
	@Bean
	public ApplicationRunner applicationRunner() {
		
		return new DataLoader();
	}

}
