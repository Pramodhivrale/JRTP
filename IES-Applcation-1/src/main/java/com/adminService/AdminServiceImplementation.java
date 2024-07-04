package com.adminService;

import java.util.List;

import org.aspectj.weaver.tools.Trace;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adminBindings.CaseWorkerData;
import com.adminBindings.PlansData;
import com.adminEntity.CaseWorkerEntity;
import com.adminEntity.PlansEntity;
import com.adminRepo.CaseWorkerRepo;
import com.adminRepo.PlansRepo;
import com.constants.AppConstants;
import com.props.AppProperties;
import com.utility.EmailUtil;

@Service
public class AdminServiceImplementation implements AdminService {

	@Autowired
	private CaseWorkerRepo caseWorkerRepo;

	@Autowired
	private PlansRepo plansRepo;

	@Autowired
	private EmailUtil emailUtil;
	
	@Autowired
	private AppProperties appProperties;

	@Override
	public Boolean addCaseWorkerData(CaseWorkerData caseWorkerData) {

		CaseWorkerEntity caseWorkerEntity = new CaseWorkerEntity();

		BeanUtils.copyProperties(caseWorkerData, caseWorkerEntity);
		caseWorkerEntity.setSsnNumber(caseWorkerData.getSsn());
		caseWorkerEntity.setAccountStatus(AppConstants.locked);
		caseWorkerRepo.save(caseWorkerEntity);

		String to = caseWorkerData.getEmailId();
		String subject = "Unlock your account here";
		StringBuffer body = new StringBuffer("");
		body.append("Use below link to unlock your account");
		body.append("<br/>");
		body.append("<a href=\"http://localhost:8080/unlock?email=" + to + "\">Click here to unlock your Account</a>");

		Boolean sentEmail = emailUtil.sentEmail(body.toString(), to, subject);
		return sentEmail;

	}

	@Override
	public String unlockAccount(String emailId) {
		CaseWorkerEntity byEmail = caseWorkerRepo.findByEmailId(emailId);
		if (byEmail == null) {
			return appProperties.getMessages().get(AppConstants.check_mail_key);
		} else {
			byEmail.setAccountStatus(AppConstants.unlocked);
			caseWorkerRepo.save(byEmail);
		}
		return appProperties.getMessages().get(AppConstants.account_unlocked_key);
	}

	@Override
	public List<CaseWorkerEntity> viewAllAccounts() {

		return caseWorkerRepo.findAll();
	}

	@Override
	public String addPlns(PlansData plansData) {
		PlansEntity plansEntity = new PlansEntity();
		plansEntity.setPlanName(plansData.getPlanName());
		plansEntity.setActiveSW(plansData.getActiveSW());
		plansRepo.save(plansEntity);
		return appProperties.getMessages().get(AppConstants.plan_added_key);

	}
	@Override
	public List<PlansEntity> viewAllPlans() {
		
		List<PlansEntity> allplans = plansRepo.findAll();
		return allplans;
	}

}
