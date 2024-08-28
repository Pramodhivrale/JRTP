package com.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {
	
	@ExceptionHandler(value = IdNotFoundException.class)
	public ResponseEntity<Ex> exInfo(IdNotFoundException notFound){
		
		Ex e=new Ex();
		e.setExname("Bad Exception");
		e.setExcepCode("ASD7896!@");
		
		return new ResponseEntity<Ex>(e,HttpStatus.BAD_REQUEST);
	}

}
