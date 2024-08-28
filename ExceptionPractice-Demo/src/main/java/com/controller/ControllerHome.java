package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.exception.IdNotFoundException;
import com.service.ServiceClass;

@RestController
public class ControllerHome {

	@Autowired
	private ServiceClass serviceClass;
	
	@GetMapping("/home")
	public String getGreting(@RequestParam("id") Integer id) throws IdNotFoundException {
		String greetingById = serviceClass.getGreetingById(id);
		return greetingById;
	}
}
