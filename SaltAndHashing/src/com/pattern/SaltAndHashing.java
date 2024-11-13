package com.pattern;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class SaltAndHashing 
{
	public static void main(String[] args) throws NoSuchAlgorithmException {
		String password="pramod123";
		
		String salting = salting();
		System.out.println(salting);
		String hashpassword = hashpassword(password,salting);
		System.out.println(hashpassword);
	}

	private static String hashpassword(String password, String salting) throws NoSuchAlgorithmException {
		MessageDigest instance = MessageDigest.getInstance("SHA-256");
		instance.update(Base64.getDecoder().decode(salting));
		byte[] digest = instance.digest(password.getBytes());
		return Base64.getEncoder().encodeToString(digest);
		
	}

	private static String salting() throws NoSuchAlgorithmException {
		SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
		byte[] salt=new byte[16];
		
		sr.nextBytes(salt);
		return Base64.getEncoder().encodeToString(salt);
		
	}

}
