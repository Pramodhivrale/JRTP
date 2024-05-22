package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.request.ForgotPassForm;
import com.request.LoginForm;
import com.request.SignupForm;
import com.request.UnlockForm;
import com.service.UserServiceImpl;

@Controller
public class UserController {
	@Autowired
	private UserServiceImpl userServiceImpl;

	@GetMapping("/signup")
	public String signUpPage(Model model) {
		model.addAttribute("user", new SignupForm());
		return "signup";
	}

	@PostMapping("/signup")
	public String addSignUpdata(@ModelAttribute("user") SignupForm form, Model model) {
		Boolean flagvalue = userServiceImpl.signUp(form);
		System.out.println(flagvalue);
		if (flagvalue) {
			model.addAttribute("succ", "Signup successful!");
		} else {
			model.addAttribute("errMsg", "Email is allready used");
		}
		return "signup";

	}

	@GetMapping("/login")
	public String showLoginPage(Model model) 
	{
		model.addAttribute("loginForm", new LoginForm());
		return "login";
	}
	
	@PostMapping("/login")
	public String login(@ModelAttribute LoginForm form,Model model) 
	{
		
		String login = userServiceImpl.login(form);
		
		if(login.contains("Succesfully loged in")) {
			
			return "redirect:/dashboard";
		}
		else {
		    model.addAttribute("loginForm", new LoginForm());
		    model.addAttribute("msg",login);
			return "login";
		}
		
		
	}

	@GetMapping("/unlock")
	public String unlockPage(@RequestParam String email, Model model) {
		// System.out.println(email);
		UnlockForm unlock = new UnlockForm();
		unlock.setEmail(email);
		model.addAttribute("unlockForm", unlock);
		return "unlock";
	}

	@PostMapping("/unlock")
	public String updatePassword(@ModelAttribute("unlockForm") UnlockForm form, Model model) {

		if(form.getNewPassword().equals(form.getConfirmPassword())) {
			String unlock = userServiceImpl.unlock(form);
			model.addAttribute("error", unlock);
		}
		else {
			model.addAttribute("error", "New password and confirm pass should match");
		}
		return "unlock";
	}

	@GetMapping("/forgot")
	public String forgotPwdPage(ForgotPassForm fPassForm,Model model) 
	{
		System.out.println(fPassForm);
		model.addAttribute("user", new ForgotPassForm());
		return "forgotPwd";
	}
	
	@PostMapping("/recoverpwd")
	public String forgotPass(ForgotPassForm forgotPassForm,Model model) 
	{
		
		model.addAttribute("user", forgotPassForm);
		String forgetPwd = userServiceImpl.forgetPwd(forgotPassForm);
		model.addAttribute("msg", forgetPwd);
		return "forgotPwd";
		
	}

}
