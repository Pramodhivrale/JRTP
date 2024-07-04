package com.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.entity.StudentEnqEntity;
import com.request.EnquiryForm;
import com.request.UpdateForm;
import com.response.DashBoardResponse;
import com.response.EnqSearchCreteria;
import com.service.EnquieryserviceImpl;

import jakarta.servlet.http.HttpSession;

@Controller
public class EnquiryController {
	@Autowired
	private HttpSession httpSession;

	@Autowired
	private EnquieryserviceImpl enquieryserviceImpl;

	@GetMapping("/logout")
	public String logout() {
		httpSession.invalidate();
		return "index";
	}

	@GetMapping("/dashboard")
	public String dashboardPage(Model model) {
		Integer id = (Integer) httpSession.getAttribute("UserID");

		DashBoardResponse dashBoardResponse = enquieryserviceImpl.getDashBoardResponse(id);
		model.addAttribute("response", dashBoardResponse);

		return "dashboard";
	}

	@GetMapping("/enquiry")
	public String addEnquiryPage(Model model) {

//		List<String> courseName = enquieryserviceImpl.getCourseName();
//		List<String> enqStatus = enquieryserviceImpl.getEnqStatus();
		EnquiryForm e = new EnquiryForm();
		model.addAttribute("enquiry", e);
		init(model);

		return "add-enquiry";
	}

	private void init(Model model) {

		List<String> classModes = Arrays.asList("Online", "Offline");
		List<String> courses = Arrays.asList("Java FullStack", "UI Development", "DevOps", "AWS"); // Assuming these are
																									// static
		List<String> statuses = Arrays.asList("NEW", "LOST", "ENROLLED");

		model.addAttribute("classModes", classModes);
		model.addAttribute("courses", courses);
		model.addAttribute("statuses", statuses);

	}

	@PostMapping("/enquiry")
	public String addEnquiry(@ModelAttribute("enquiry") EnquiryForm enquiryForm, Model model) {

		String enq = enquieryserviceImpl.addEnq(enquiryForm);
		model.addAttribute("enquiryAdded", enq);
		init(model);
		return "add-enquiry";
	}

	@GetMapping("/enquaries")
	public String viewEnquiryPage(@ModelAttribute EnqSearchCreteria searchCreteria, Model model) {

		Integer id = (Integer) httpSession.getAttribute("UserID");

		List<StudentEnqEntity> enquiries = enquieryserviceImpl.getEnquries(id);

		init(model);

		model.addAttribute("enquiries", enquiries);

		return "view-enquriy";
	}

	@GetMapping("/edit/{enqId}")
	public String editInquiry(@PathVariable("enqId") Integer id, Model model) {

		Optional<StudentEnqEntity> editEnq = enquieryserviceImpl.editEnq(id);
		StudentEnqEntity studentEnqEntity = editEnq.get();

		EnquiryForm enquiryForm = new EnquiryForm();
		enquiryForm.setStudentName(studentEnqEntity.getStudentName());
		enquiryForm.setContactNo(studentEnqEntity.getPhonNo());
		enquiryForm.setClassMode(studentEnqEntity.getClassMode());
		enquiryForm.setCourseName(studentEnqEntity.getCourseName());
		enquiryForm.setEnqStatus(studentEnqEntity.getEnqStatus());

		model.addAttribute("form", enquiryForm);
		init(model);
		model.addAttribute("id", id);
		return "update.html";
	}

	@PostMapping("update/{id}")
	public String updateEnq(@PathVariable Integer id, @ModelAttribute UpdateForm form, Model model) {
		String updateStudentData = enquieryserviceImpl.updateStudentData(id, form);
		model.addAttribute("msg", updateStudentData);
		model.addAttribute("form", new UpdateForm());
		return "redirect:/enquaries";

	}

	@PostMapping("/filter-enq")
	public String filterEnq(@RequestParam ("courseName") String cName, 
			                @RequestParam ("classMode")String cMode,
			                @RequestParam ("enqStatus") String eStatus,
			                Model model) {
		
		EnqSearchCreteria eCreteria=new EnqSearchCreteria();
		eCreteria.setCourseName(cName);
		eCreteria.setClassMode(cMode);
		eCreteria.setEnqStatus(eStatus);
		
		Integer id = (Integer) httpSession.getAttribute("UserID");
		List<StudentEnqEntity> filterEnq = enquieryserviceImpl.filterEnq(id,eCreteria);
		model.addAttribute("enquiries", filterEnq);

		return "filter";
	}

}
