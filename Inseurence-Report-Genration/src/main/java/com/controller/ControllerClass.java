package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpServletResponse;

import com.entity.CustomerDataEntity;
import com.req.SearchReqData;
import com.service.*;
@Controller
public class ControllerClass 
{
	@Autowired
	private ServiceClass service;
	
	@GetMapping("/pdf")
	public void getPdf(HttpServletResponse response) throws Exception {
	    // Set the correct content type for a PDF file
	    response.setContentType("application/pdf");
	    
	    // Set the header for the response to indicate a file attachment
	    response.setHeader("Content-Disposition", "attachment; filename=plans.pdf");
	    
	    // Call the service method to generate and write the PDF content
	    service.getPdf(response);
	}

	
	@GetMapping("/excel")
	public void getExcel(HttpServletResponse response) throws Exception {
	    // Set the content type and the header for the response
	    response.setContentType("application/vnd.ms-excel");
	    response.setHeader("Content-Disposition", "attachment; filename=plans.xls");
	    
	    // Call the service method to write the Excel content to the response
	    service.getExcel(response);
	}

	@PostMapping("/search")
	public String getAllData(@ModelAttribute("searchForm") SearchReqData searchReqData,Model model)
	{
		
		List<CustomerDataEntity> citizens = service.getAllData(searchReqData);
		 model.addAttribute("citizens", citizens);
		 init(model); 
		return "index";
		
	}
	
	@GetMapping("/")
	public String loadFrom(Model model)
	{
		model.addAttribute("searchForm", new SearchReqData());
		init(model);
		return"index";	
		
	}

	private void init(Model model) {
		
		model.addAttribute("planNames", service.getPlanNames());
		model.addAttribute("planStatuses", service.getPlanStatus());
	}
	

}
