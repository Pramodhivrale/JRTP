package com.data;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.adminRepo")
@ComponentScan(basePackages = "com.*")
@EntityScan(basePackages = "com.adminEntity")
public class IesApplcation1Application {

	public static void main(String[] args) {
		SpringApplication.run(IesApplcation1Application.class, args);
	}

}
