package com.example.TestingDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.web.bind.annotation.RestController
public class RestController {

	@Autowired
	public UtilMethods utilMethods;
	
	@GetMapping("/welcome")
	public String welcomemsg() {
		String welcome = utilMethods.welcome();
		return welcome;
	}
	
	@GetMapping("/greet")
	public String greet() {
		String greet = utilMethods.greet();
		return greet;
	}
}
