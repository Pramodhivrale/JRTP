package com.adminController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.adminBindings.CaseWorkerData;
import com.adminBindings.PlansData;
import com.adminEntity.CaseWorkerEntity;
import com.adminEntity.PlansEntity;
import com.adminService.AdminServiceImplementation;
import com.constants.AppConstants;
import com.props.AppProperties;

@RestController
public class AdminController {
	@Autowired
	private AdminServiceImplementation admin;

	@Autowired
	private AppProperties appProperties;

	@PostMapping("/caseworker")
	public String getCaseWorkerData(@RequestBody CaseWorkerData caseWorkerData) {

		Boolean flag = admin.addCaseWorkerData(caseWorkerData);
		if (flag == true) {
			return appProperties.getMessages().get(AppConstants.mail_key);	
		} else {
			return appProperties.getMessages().get(AppConstants.problem_key);
		}

	}

	@GetMapping("/unlock")
	public String unlockAccount(@RequestParam("email") String emailId) {
		String unlockAccount = admin.unlockAccount(emailId);
		return unlockAccount;
	}

	@PostMapping("/viewAccounts")
	public List<CaseWorkerEntity> viewAllAccounts() {
		List<CaseWorkerEntity> viewAllAccounts = admin.viewAllAccounts();
		return viewAllAccounts;

	}

	@PostMapping("/plan")
	public String createPlan(@RequestBody PlansData plansData) {
		System.out.println(plansData);
		return admin.addPlns(plansData);
	}

	@GetMapping("/getPlans")
	public List<PlansEntity> getAllPlans() {
		return admin.viewAllPlans();
	}

}
