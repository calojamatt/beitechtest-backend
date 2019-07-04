package com.beitechtest.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.beitechtest")
@SpringBootApplication
public class BeitechtestcammApplication {

	public static void main(String[] args) {
		SpringApplication.run(BeitechtestcammApplication.class, args);
	}
}
