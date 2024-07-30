package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.FeignClientDemo;

@RestController
public class ControllerClass {

	@Autowired
	private FeignClientDemo fDemo;
	
	@GetMapping("/welcome")
	public String welcomeText() {
		
		String invokeGreetApi = fDemo.invokeGreetApi();
		
		return invokeGreetApi  + "to jumanji";
	}
}
