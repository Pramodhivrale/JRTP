package com.service;

import com.request.ForgotPassForm;
import com.request.LoginForm;
import com.request.SignupForm;
import com.request.UnlockForm;

public interface UserService 
{
	public String login(LoginForm form);
	
	public Boolean signUp(SignupForm form);
	
	public String unlock(UnlockForm form);
	
//	public String forgetPwd(String email);

	public String forgetPwd(ForgotPassForm pass);

}
