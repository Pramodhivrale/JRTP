package com.genretors;

import java.util.Random;

import org.springframework.context.annotation.Configuration;

@Configuration
public class PasswordGenerator {

    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!";

    public static String generatePassword(int length) {
        StringBuilder password = new StringBuilder(length);
        Random random=new Random();
        
        for (int i = 0; i < length; i++) {
            password.append(CHARACTERS.charAt(random.nextInt(CHARACTERS.length())));
        }
        return password.toString();
    }
}
