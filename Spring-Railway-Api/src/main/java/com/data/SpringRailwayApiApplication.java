package com.data;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.data","com.req","com.controller"})
public class SpringRailwayApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringRailwayApiApplication.class, args);
	}

}
