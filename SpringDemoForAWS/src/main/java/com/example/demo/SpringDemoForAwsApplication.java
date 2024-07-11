package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.example.demo")
public class SpringDemoForAwsApplication {


	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(SpringDemoForAwsApplication.class, args);
		
       UserRepo bean = run.getBean(UserRepo.class);
       
       UserData data=new UserData();
		
		data.setUsedId(1);
		data.setUserName("pramod");
		data.setUserDept("English");
		data.setUserGender("male");
		
		UserData save = bean.save(data);
		System.out.println("Data saved");
	}

}
