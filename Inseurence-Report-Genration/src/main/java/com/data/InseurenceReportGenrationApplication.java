package com.data;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages = {"com.data","com.controller","com.repo","com.runners","com.service"})
public class InseurenceReportGenrationApplication {

	
		
		public static void main(String[] args) {
			SpringApplication.run(InseurenceReportGenrationApplication.class, args);
		}
	
		
		
	

}
