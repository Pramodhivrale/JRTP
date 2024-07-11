package com.utility;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import jakarta.mail.internet.MimeMessage;

@Configuration
public class EmailSender 
{
	@Autowired
	private JavaMailSender javaMailSender;
	
	 private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@(.+)$";

	    public Boolean sendEmail(String subject, String body, String to) {
	        boolean flag = false;
	        try {
	            if (!isValidEmail(to)) {
	            	System.out.println(to);
	                throw new IllegalArgumentException("Invalid email address: " + to);
	            }

	            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
	            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true, "UTF-8");

	            System.out.println("Email :"+to);
	            messageHelper.setTo(to.trim());
	            messageHelper.setSubject(subject);
	            messageHelper.setText(body, true);
	            javaMailSender.send(mimeMessage);

	            flag = true;
	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        return flag;
	    }

	    private boolean isValidEmail(String email) {
	        Pattern pattern = Pattern.compile(EMAIL_REGEX);
	        return pattern.matcher(email).matches();
	    }
	
//	public Boolean sendEmail(String body, String to, String subject) {
//		boolean flag = false;
//		try {
//			MimeMessage mimeMessage = javaMailSender.createMimeMessage();
//
//			MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage,true,"UTF-8");
//			
//			messageHelper.setTo(to.trim());
//			messageHelper.setSubject(subject);
//			messageHelper.setText(body,true);
//			javaMailSender.send(mimeMessage);
//
//			flag = true;
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		return flag;
//	}

}
