package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetController {

	@Autowired
	private Environment environment;
	
	@GetMapping("/greet")
	public String greetMsg() {
		String property = environment.getProperty("server.port");
		
		return "Welcome "+ property;
	}
}
