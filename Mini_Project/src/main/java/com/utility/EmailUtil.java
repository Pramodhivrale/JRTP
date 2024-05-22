package com.utility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import jakarta.mail.internet.MimeMessage;

@Component
public class EmailUtil {
	@Autowired
	private JavaMailSender javaMailSender;

	public boolean sentemail(String body, String to, String subject) {
		boolean flag = false;
		try {
			MimeMessage mimeMessage = javaMailSender.createMimeMessage();

			MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);

			messageHelper.setTo(to);
			messageHelper.setSubject(subject);
			messageHelper.setText(body);

			javaMailSender.send(mimeMessage);

			flag = true;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return flag;
	}
	public String forgetPassSentMail(String body,String to,String subject) 
	{
		try {
			MimeMessage mimeMessage = javaMailSender.createMimeMessage();
 
			MimeMessageHelper messageHelper=new MimeMessageHelper(mimeMessage);
			
			messageHelper.setTo(to);
			messageHelper.setSubject(subject);
			messageHelper.setText(body);

			javaMailSender.send(mimeMessage);
	         return "Your password is sent to your email";	
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return "Error";
		
	}

}
