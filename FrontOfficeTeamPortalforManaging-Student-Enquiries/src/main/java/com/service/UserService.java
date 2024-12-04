package com.service;

import com.bindings.ForgotPassForm;
import com.bindings.LoginForm;
import com.bindings.SignupForm;
import com.bindings.UnlockForm;

public interface UserService 
{
	public String login(LoginForm form);
	
	public boolean signUp(SignupForm form);
	
	public String unlock(UnlockForm form);
	
//	public String forgetPwd(String email);

	public String forgetPwd(ForgotPassForm pass);

}
