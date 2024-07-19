package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bindings.CitizenBinding;
import com.entity.ArEntity;
import com.service.ArServiceImplementation;

@RestController
public class AR_CONTROLLER {
	@Autowired
	private ArServiceImplementation serviceImplementation;

	@PostMapping("/userReg")
	public String cwAccountCreation(@RequestParam("email") String email, @RequestBody CitizenBinding citizenBinding) {
		return serviceImplementation.registerApplication(citizenBinding, email);

	}

	@GetMapping("/getusers")
	public List<ArEntity> getAllUser() {
		return serviceImplementation.getAllApplicationOfCaseW();

	}

}
