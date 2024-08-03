package com.data;

public class PalindormeCheck 
{
	public boolean palindormeCheck(String str) {
		
		String rev="";
		
		int length = str.length();
		
		for(int i=length-1;i>=0;i--) {
			rev=rev+ str.charAt(i);
		}
		
		if(str.equals(rev)) {
			return true;
		}else {
			return false;
		}
	}

}
