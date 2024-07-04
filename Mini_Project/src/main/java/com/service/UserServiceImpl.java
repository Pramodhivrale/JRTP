package com.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.constants.AppConst;
import com.entity.UserDtlsEntity;
import com.repo.UserDetailsRepo;
import com.request.ForgotPassForm;
import com.request.LoginForm;
import com.request.SignupForm;
import com.request.UnlockForm;
import com.utility.*;

import jakarta.servlet.http.HttpSession;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDetailsRepo userDetailsRepo;

	@Autowired
	private EmailUtil emailUtils;
	
	@Autowired
	private HttpSession httpSession;

	@Override
	public String login(LoginForm form) 
	{
		UserDtlsEntity byEmailAndPwd = userDetailsRepo.findByEmailAndPwd(form.getUserName(), form.getPassword());
		
		if(byEmailAndPwd == null) {
			return "Invalid credentials";
		}
		if(byEmailAndPwd.getAccStatus().equals("LOCKED")) 
		{
			return "Your account is locked ! Please unlock your account";
			
		}
		// Create session and store user data
		
		httpSession.setAttribute("UserID", byEmailAndPwd.getUserId());
//		System.out.println(byEmailAndPwd.getUserId());
		return "Succesfully loged in";
	}

	@Override
	public boolean signUp(SignupForm form) {

		UserDtlsEntity userDtlsEntity = userDetailsRepo.findByEmail(form.getEmail());
		if (userDtlsEntity != null) {
			return false;
		}
		// TODO : Genrate Random Password
		String tempPwd = PwdGenrator.passGen();

		UserDtlsEntity entity = new UserDtlsEntity();
		BeanUtils.copyProperties(form, entity);

		// TODO : Set acc status as Locked
		entity.setAccStatus("LOCKED");
		entity.setPwd(tempPwd);

		userDetailsRepo.save(entity);

		// TODO : Send that random password to user via emial
		String to = form.getEmail();
		String subject = AppConst.SUBJECT;
		StringBuffer body = new StringBuffer("");
		body.append("<h1>Use below temp password to unlock your account</h1>");
		body.append("Temporary pwd : " + tempPwd);
		body.append("<br/>");
		body.append("<a href=\"http://localhost:8080/unlock?email=" + to + "\">Click here to unlock your email</a>");

		emailUtils.sentemail(body.toString(), to, subject);

		return true;
	}

	@Override
	public String unlock(UnlockForm form) {
		UserDtlsEntity entity = userDetailsRepo.findByEmail(form.getEmail());
		if(entity.getPwd().equals(form.getTempPassword())) {
			entity.setPwd(form.getNewPassword());
			entity.setAccStatus("UNLOCKED");
			userDetailsRepo.save(entity);
			return "Your account is unlocked";
		}
		else {
			return "Your password is incorrect";
		}
		
		
	}

	@Override
	public String forgetPwd(ForgotPassForm pass) 
	{
		UserDtlsEntity email = userDetailsRepo.findByEmail(pass.getEmail());
		String subject="your Password";
		String to=pass.getEmail();
		String body="Your Recovery Password : "+email.getPwd();
		
		String string = emailUtils.forgetPassSentMail(body, to, subject);
		
		return string;
	}



	
}
