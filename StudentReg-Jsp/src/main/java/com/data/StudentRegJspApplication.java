package com.data;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.data","com.controller","com.pojo"})
public class StudentRegJspApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentRegJspApplication.class, args);
	}

}
