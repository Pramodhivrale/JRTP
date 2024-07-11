package com.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandeler 
{
	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<AppException> handelException(String message){
		
		AppException ex=new AppException();
		ex.setExcode("EXC123");
		ex.setExDescription("Which exception");
		ex.setExDate(LocalDateTime.now());
		
		return new ResponseEntity<>(ex,HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
