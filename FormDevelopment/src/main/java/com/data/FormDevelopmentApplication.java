package com.data;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.data","com.main"})
public class FormDevelopmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(FormDevelopmentApplication.class, args);
	}

}
