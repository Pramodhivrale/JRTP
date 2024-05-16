package com.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.pojo.Student;

@Controller
public class ControllerClass 
{
	@GetMapping("/")
	public String loadFrom(Model model)
	{
		List<String> coursesList=new ArrayList<>();
		coursesList.add("Java");
		coursesList.add("Paython");
		coursesList.add("AWS");
		
		List<String> courseTimings=new ArrayList<>();
		coursesList.add("Morning");
		coursesList.add("Night");
		
		model.addAttribute("course",coursesList);
		model.addAttribute("timings", courseTimings);
		
		model.addAttribute("student",new Student());
		return "index";
	}

}
