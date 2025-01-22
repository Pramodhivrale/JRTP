package com.example.TestingDemo;

import org.springframework.stereotype.Service;

@Service
public class ServiceClass implements UtilMethods {

	@Override
	public String welcome() {
		
		return "Welcome to rest-api unit testting";
	}

	@Override
	public String greet() {
		return "Welcome to the rest api unitntsting with greet";
	}

}
