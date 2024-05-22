package com.utility;

import org.apache.commons.lang3.RandomStringUtils;

public class PwdGenrator {
	public static String passGen() {
		String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		String pwd = RandomStringUtils.random(6, characters);
		return pwd;
	}

}
