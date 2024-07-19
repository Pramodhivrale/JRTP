package com.example.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.service.ServiceClass;

@RestController
public class MsgController {
	@Autowired
	private ServiceClass service;

	@GetMapping("/Welcome")
	public ResponseEntity<String> welcomeMsg() {
		String message = service.getMessage();

		return new ResponseEntity<>(message, HttpStatus.OK);
	}

}
