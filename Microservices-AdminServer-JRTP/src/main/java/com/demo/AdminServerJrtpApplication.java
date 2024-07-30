package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import de.codecentric.boot.admin.server.config.EnableAdminServer;

@SpringBootApplication
@EnableAdminServer
@ComponentScan(basePackages = "com.*")
public class AdminServerJrtpApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdminServerJrtpApplication.class, args);
	}

}
