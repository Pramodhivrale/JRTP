package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bindings.AdminLogin;
import com.bindings.IesBinding;
import com.bindings.Plansbinding;
import com.bindings.UnlockBinding;
import com.entity.IesUserEntity;
import com.entity.PlansEntity;
import com.props.AppConstants;
import com.props.PropertiesConfiguration;
import com.service.AdminServiceImplementation;

@RestController
public class AdminController {
	
	
	@Autowired
	private AdminServiceImplementation adminService;
	
	@Autowired
	private PropertiesConfiguration props;

	@PostMapping("/caseworker")
	public String getCaseWorker(@org.springframework.web.bind.annotation.RequestBody IesBinding iesUser) {

		Boolean flag = adminService.addCaseWorker(iesUser);
		if (flag == true) {
			//return "User Account is created! please check your email to unlock or update your password to login";
			return props.getMessage().get(AppConstants.account_created);
		} else {
			return props.getMessage().get(AppConstants.account_present);
		}

	}
	
	@GetMapping("/unlockAccount")
	public String unlockAccount(@RequestParam("email") String email) {
		System.out.println(email);
		String unlockAccount = adminService.unlockAccount(email);
		return unlockAccount;
	}
	
	@PostMapping("updatePwd")
	public String updatePwd(@RequestBody UnlockBinding unlockBinding) 
	{
	    return adminService.updatePwd(unlockBinding);
		
	}
	
	@GetMapping("/getcaseworker")
	public List<IesUserEntity> viewAllCaseWorkerAccounts() {
		
		return adminService.getAllCaseWorkers();
		
	}
	
	@PutMapping("/adswitch")
	public String activeSwitch(@RequestParam Integer userId) {
		
		IesUserEntity adswitch = adminService.adswitch(userId);
		if(adswitch.getActiveSwitch().equals("N")) {
			return AppConstants.deactivate;
		}
		else {
			return AppConstants.activated;
		}
		
	}
	
	@PutMapping("edit")
	public String editUser(@RequestParam Integer userId) {
		
		adminService.updateUser(userId);
		return null;
	}
	
	
	@GetMapping("/adminlogin")
	public String adminLogin(@RequestBody AdminLogin adminLogin) {
		
		String adminLogin2 = adminService.adminLogin(adminLogin);
		if(adminLogin2.contains("Admin logged in")) {
			//return "redirect:/dashboard";
			return AppConstants.adminloggedin;
		}
		if (adminLogin2.contains("Case Worker logged in")) {
			return AppConstants.cw;
		}
		else {
			return AppConstants.InvalidCredentials;
		}
	}
	
	@PostMapping("/recover")
	public String recoverPassword(String email) {
		Boolean recoveryPazzword = adminService.recoveryPazzword(email);
		if(recoveryPazzword) {
			return " Password sent to your mail";
		}
		else {
			return "Error !";
		}
		
	}
	
	@PostMapping("/dashboard")
	public String getDashboardData(@RequestParam("email") String email) {
		String dashboardData = getDashboardData(email);
		
		return null;
	}
	
	@PostMapping("createPlan")
	public String createPlan(@RequestBody Plansbinding plans) {
		
		PlansEntity plans2 = adminService.addPlans(plans);
		if(plans2 != null) {
			return AppConstants.planSaved;
		}
		return AppConstants.planNotSaved;
	}
	
	@GetMapping("/viewplans")
	public List<PlansEntity> viewPlans() {
		return adminService.viewAllPlans();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
