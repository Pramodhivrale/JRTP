package com.exception;

import java.time.LocalDateTime;

public class AppException 
{
	private String excode;
	
	private String exDescription;
	
	private LocalDateTime exDate;

	public String getExcode() {
		return excode;
	}

	public void setExcode(String excode) {
		this.excode = excode;
	}

	public String getExDescription() {
		return exDescription;
	}

	public void setExDescription(String exDescription) {
		this.exDescription = exDescription;
	}

	public LocalDateTime getExDate() {
		return exDate;
	}

	public void setExDate(LocalDateTime exDate) {
		this.exDate = exDate;
	}
	
	

}
