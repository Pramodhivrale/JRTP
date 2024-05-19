package com.service;

import com.request.LoginForm;
import com.request.SignupForm;
import com.request.UnlockForm;

public interface UserService 
{
	public String login(LoginForm form);
	
	public String signUp(SignupForm form);
	
	public String unlock(UnlockForm form);
	
	public String forgetPwd(String email);

}
