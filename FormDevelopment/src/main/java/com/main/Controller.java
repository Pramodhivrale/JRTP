package com.main;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
@org.springframework.stereotype.Controller
public class Controller 
{
	@GetMapping("/")
	public String view()
	{
		return "index";
	}
	
	@PostMapping("/user")
	public String handleSubmitBtn(PojoClassUser pojoClassUser, Model model) {

		System.out.println(pojoClassUser);
		

		
		model.addAttribute("msg", "User Saved");

		return "index";
	}

}
