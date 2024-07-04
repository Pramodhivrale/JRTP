package com.data;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.*")
public class RestApiDevelepomentProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestApiDevelepomentProviderApplication.class, args);
	}

}
