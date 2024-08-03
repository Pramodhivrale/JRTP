package com.data;

public class StringVerifying 
{
	public static Integer verifyString(String data) {
		if(data == null || data.trim().length() == 0) {
			throw new IllegalArgumentException("String must not be null or empty !");
		}
		return Integer.valueOf(data);
	}

}
