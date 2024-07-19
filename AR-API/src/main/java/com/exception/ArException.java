package com.exception;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;

@Data
public class ArException 
{
	private String exCode;
	
	private String exDesc;
	
	@CreationTimestamp
	private LocalDateTime exceptionCreated;

}
