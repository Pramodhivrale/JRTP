package com.test;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import com.data.PalindormeCheck;

public class PalindromeTest 
{
	@ParameterizedTest
	@ValueSource(strings = {"radar","madam","pramod"})
	public void checkPalindormeTest(String check) {
		PalindormeCheck p1=new PalindormeCheck();
		boolean palindormeCheck = p1.palindormeCheck(check);
		assertTrue(palindormeCheck);
	}

}
