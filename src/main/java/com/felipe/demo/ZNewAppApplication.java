package com.felipe.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class ZNewAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZNewAppApplication.class, args);
	}

}
