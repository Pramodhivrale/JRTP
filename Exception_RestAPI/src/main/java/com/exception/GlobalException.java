package com.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GlobalException {
	
	
	@ExceptionHandler(value = UserNotFoundException.class)
	public ResponseEntity<Exbinding> handelEx(UserNotFoundException exc) {
		
		Exbinding ex=new Exbinding();
		ex.setCode("XD85L");
		ex.setDate(LocalDateTime.now());
		ex.setMsg(exc.getMessage());
		
		return new ResponseEntity<Exbinding>(ex,HttpStatus.BAD_REQUEST);
	}

}
