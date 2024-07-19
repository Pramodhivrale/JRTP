package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.exception.UserNotFoundException;
import com.service.UserService;

@RestController
public class ControllerClass 
{
	@Autowired
	private UserService userService;
	
	@GetMapping("/user/{userid}")
	public String getCustomer(@PathVariable ("userid") Integer userid) throws UserNotFoundException 
	{
		
		String user = userService.getUser(userid);
		return user;
	}

}
