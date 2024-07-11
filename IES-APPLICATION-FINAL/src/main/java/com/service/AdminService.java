package com.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bindings.AdminLogin;
import com.bindings.DashboardPage;
import com.bindings.IesBinding;
import com.bindings.Plansbinding;
import com.bindings.UnlockBinding;
import com.entity.IesUserEntity;
import com.entity.PlansEntity;

@Service
public interface AdminService {
	
	public Boolean addCaseWorker(IesBinding iseUser);
	
	public List<IesUserEntity> getAllCaseWorkers();
	
	public IesUserEntity adswitch(Integer userId);
	
	public String updateUser(Integer userId);
	
	public String adminLogin(AdminLogin adminLogin);
	
	public String unlockAccount(String email);
	
	public String updatePwd(UnlockBinding unlockBinding);
	
	public PlansEntity addPlans(Plansbinding plansbinding);
	
	public List<PlansEntity>  viewAllPlans();
	
	public DashboardPage getDashboardData(String email);
	
	public Boolean recoveryPazzword(String email);

	//public String unlockAccount(String email, UnlockBinding unlockBinding);

}
