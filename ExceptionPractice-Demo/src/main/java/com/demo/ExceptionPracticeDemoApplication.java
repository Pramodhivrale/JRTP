package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.*")
public class ExceptionPracticeDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExceptionPracticeDemoApplication.class, args);
	}

}
