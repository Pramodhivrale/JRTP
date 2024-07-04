package com.decoder;

import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;

public class EncoderDecoder 
{
	public static void main(String[] args) {
		 String name ="pramod";
		 
		 Encoder encoder = Base64.getEncoder();
		 String encodeToString = encoder.encodeToString(name.getBytes());
		 System.out.println(encodeToString);
		 
		 Decoder decoder = Base64.getDecoder();
		 byte[] decode = decoder.decode(encodeToString);
		 System.out.println(new String(decode));
	}

}
