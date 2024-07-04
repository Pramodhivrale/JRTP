package com.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController 
{
	@Autowired
	private MapClass mapClass;
	
	@GetMapping("/greet")
	public String greetMsg() {
		Map<String,String> messages = mapClass.getMessages();
		return messages.get("greetMsg");
	}
	
	@GetMapping("/welcome")
	public String welcomeMsg() {
		
		Map<String,String> messages = mapClass.getMessages();
		return  messages.get("welcomeMsg");
		
	}

}
