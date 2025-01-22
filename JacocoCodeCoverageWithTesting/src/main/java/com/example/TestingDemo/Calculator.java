package com.example.TestingDemo;

public class Calculator {
	
	public int addition(int a, int b) {
		return a + b;
	}
	public boolean checkPalindrome(String str) {
		String reverse="";
		for(int i=str.length()-1;i>=0;i--) {
			reverse=reverse+str.charAt(i);
		}
		if(str.equals(reverse)) {
			return true;
		}
		else {
			return false;
		}
	}

}
