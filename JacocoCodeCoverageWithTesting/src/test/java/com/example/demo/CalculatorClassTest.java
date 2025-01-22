package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import com.example.TestingDemo.Calculator;

public class CalculatorClassTest {

	private Calculator c = new Calculator();

	@Test
	public void add() {

		int addition = c.addition(90, 100);
		int expected = 190;
		assertEquals(expected, addition);
	}
	@ParameterizedTest
	@ValueSource(strings = {"madam","liril","racecar"})
	public void checkpalindrome(String str) {
      boolean checkPalindrome = c.checkPalindrome(str);
      assertTrue(checkPalindrome);
	}
}
