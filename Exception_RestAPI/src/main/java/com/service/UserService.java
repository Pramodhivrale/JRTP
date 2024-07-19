package com.service;

import org.springframework.stereotype.Service;

import com.exception.UserNotFoundException;

@Service
public class UserService {
	
	
	public String getUser(Integer id) throws UserNotFoundException {
		
		if(id > 100) {
			return "Jhon cena";
		}
		else {
			throw new UserNotFoundException("Invalid customer id");
		}
   
	}

}
