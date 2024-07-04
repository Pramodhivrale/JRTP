package com.adminService;

import java.util.List;

import com.adminBindings.CaseWorkerData;
import com.adminBindings.PlansData;
import com.adminEntity.CaseWorkerEntity;
import com.adminEntity.PlansEntity;

public interface AdminService 
{
	public Boolean addCaseWorkerData(CaseWorkerData caseWorkerData);
	
	public String unlockAccount(String emailId);
	
	public List<CaseWorkerEntity> viewAllAccounts();
	
	public String addPlns(PlansData plansData);
	
	public List<PlansEntity> viewAllPlans();

}
