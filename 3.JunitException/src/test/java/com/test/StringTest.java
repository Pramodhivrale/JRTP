package com.test;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.data.StringVerifying;

public class StringTest 
{
	@Test
	public void verifyString() {
		String data=null;
		assertThrows(IllegalArgumentException.class, () -> StringVerifying.verifyString(data));
	}

}
