package com.service;

import org.springframework.stereotype.Service;

import com.exception.IdNotFoundException;

@Service
public class ServiceClass {

	public String getGreetingById(Integer id) throws IdNotFoundException {
		if(id > 100) {
			return "Hellllo id ";
		}
		else {
			throw new IdNotFoundException("User Id is not found sorry");
		}
	}
}
