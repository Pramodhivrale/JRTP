package com.decoder;

import java.security.MessageDigest;
import java.util.Base64;

public class Encryption 
{
	public static void main(String[] args) throws Exception {
		String name="abc@12";
		
		MessageDigest instance = MessageDigest.getInstance("SHA-256");
		
		instance.reset();
		
		instance.update(name.getBytes());
		
		byte[] digest = instance.digest();
		
		System.out.println(new String(digest));
		
		byte[] encode = Base64.getEncoder().encode(digest);
		System.out.println(new String(encode));
	}

}
