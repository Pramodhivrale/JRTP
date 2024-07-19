package com.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.data.Calcu;

public class CalcuTest 
{
	@Test
	public void additionTest() {
		Calcu c1=new Calcu();
		
		int addition = c1.addition(10, 5);
        assertEquals(15, addition);		
	}

}
