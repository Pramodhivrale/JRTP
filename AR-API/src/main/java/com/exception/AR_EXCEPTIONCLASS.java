package com.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AR_EXCEPTIONCLASS {
	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<ArException> exception(Exception e) {

		ArException ax = new ArException();
		ax.setExCode("EX8596");
		ax.setExDesc(e.getMessage());

		return new ResponseEntity<ArException>(ax, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
