package com.service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bindings.AdminLogin;
import com.bindings.DashboardPage;
import com.bindings.IesBinding;
import com.bindings.Plansbinding;
import com.bindings.UnlockBinding;
import com.entity.IesUserEntity;
import com.entity.PlansEntity;
import com.genretors.PasswordGenerator;
import com.props.AppConstants;
import com.repo.IesRepo;
import com.repo.PlansRepo;
import com.utility.EmailSender;

import jakarta.servlet.http.HttpSession;

@Service
public class AdminServiceImplementation implements AdminService
{
	@Autowired
	private IesRepo iesRepo;
	
	@Autowired
	private EmailSender emailSender;
	
	@Autowired
	private PlansRepo plansRepo;
	
	@Autowired
	private HttpSession httpSession;
	
	
	@Override
	public Boolean addCaseWorker(IesBinding iseUser) {
		
		IesUserEntity byUserEmail = iesRepo.findByUserEmail(iseUser.getUserEmail());
		if(byUserEmail != null) {
			return false;
		}
		
		IesUserEntity iesEntity=new IesUserEntity();
		iesEntity.setActiveSwitch("Y");
		iesEntity.setUserAccountStatus("LOCKED");
		iesEntity.setUserPwd(PasswordGenerator.generatePassword(8));	
		BeanUtils.copyProperties(iseUser, iesEntity);
		
		IesUserEntity iesUser = iesRepo.save(iesEntity);

		String subject = "User Registration";
		String body = readEmailBody("RegisterUserBodyMail.txt", iesUser);
		return emailSender.sendEmail(subject, body, iesUser.getUserEmail());
		
//		String to=iesUser.getUserEmail();
//		String subject="Unlock your account here";
//		StringBuffer body=new StringBuffer("");
//		body.append("Use below link to unlock your account");
//		body.append("<br/>");
//		body.append("Your temp Password :"+iesUser.getUserPwd());
//		body.append("<br/>");
//		body.append("<a href=\"http://localhost:8080/unlockAccount?email=" + to + "\">Click here to unlock your Account</a>");
//		
//		return emailSender.sendEmail(body.toString(), to, subject);
		
	}
	
	@Override
	public String unlockAccount(String email) {
        IesUserEntity byUserEmail = iesRepo.findByUserEmail(email);
        if(byUserEmail.getUserAccountStatus().equals(AppConstants.locked)) 
        {
        	byUserEmail.setUserAccountStatus(AppConstants.unlocked);
        	IesUserEntity save = iesRepo.save(byUserEmail);
        	return"Unlocked";
        }
		else {
			return AppConstants.accountAllUnlocked;
		}
	}
	
	@Override
	public String updatePwd(UnlockBinding unlockBinding) {
		
		IesUserEntity update = iesRepo.findByUserEmail(unlockBinding.getUserEmail());
		if(update != null) {
			update.setUserPwd(unlockBinding.getConfirmPwd());
		    iesRepo.save(update);
			return AppConstants.pwdUpdated;
		}
		return AppConstants.pwdNotUpdated;
	}
	
	@Override
	public List<IesUserEntity> getAllCaseWorkers() {
		
		return iesRepo.findAll();
	}
	
	@Override
	public IesUserEntity adswitch(Integer userId) {
		 Optional<IesUserEntity> byId = iesRepo.findById(userId);
		    IesUserEntity iesUserEntity = byId.get();
		    String currentSwitchState = iesUserEntity.getActiveSwitch();
		    String newSwitchState = "Y".equals(currentSwitchState) ? "N" : "Y";

		    iesUserEntity.setActiveSwitch(newSwitchState);
		    return iesRepo.save(iesUserEntity);
	}

	@Override
	public String updateUser(Integer userId) {
//		Optional<IesUserEntity> byId = iesRepo.findById(userId);
//		if(byId.isPresent()) {
//			IesUserEntity iesUserEntity = byId.get();
//			
//		}
		return null;
	}
	
	@Override
	public String adminLogin(AdminLogin adminLogin) {
		
		IesUserEntity iesUser = iesRepo.findByUserEmailAndUserPwd(adminLogin.getUserEmail(), adminLogin.getUserPwd());
	    
	    if (iesUser == null) {
	        return AppConstants.invalidPass;
	    }

	    if ("LOCKED".equals(iesUser.getUserAccountStatus())) {
	        return AppConstants.unlockAcc;
	    }

	    if ("N".equals(iesUser.getActiveSwitch())) {
	        return AppConstants.activeAcc;
	    }

	    if (iesUser.getUserRole() == 1) {
	       // httpSession.setAttribute("UserId", iesUser.getUserId());
	       // return "Admin logged in";
	    	return "redirect:/dashboard?email+"+iesUser.getUserEmail();
	    } else if (iesUser.getUserRole() == 2) {
	        httpSession.setAttribute("UserId", iesUser.getUserId());
	        return "redirect:/dashboard?email+"+iesUser.getUserEmail();
	        //return AppConstants.caseworker;
	    }
	    
	    return AppConstants.unknownrole;
	}
	
	@Override
	public Boolean recoveryPazzword(String email) {
		
		IesUserEntity byUserEmail = iesRepo.findByUserEmail(email);
		if("UNLOCKED".equals(byUserEmail.getUserAccountStatus())) {
			return false;
		}
		
		String subject = "User Registration";
		String body = readEmailBody("RecoveryPassword.txt", byUserEmail);
		return emailSender.sendEmail(subject, body, byUserEmail.getUserEmail());
	}
	
	@Override
	public DashboardPage getDashboardData(String email) {
		
		return null;
	}
	
	@Override
	public PlansEntity addPlans(Plansbinding plansbinding) {
		
		Integer id =(Integer) httpSession.getAttribute("UserId");
		Optional<IesUserEntity> byId = iesRepo.findById(id);
		IesUserEntity iesUserEntity = byId.get();
		
		PlansEntity plansEntity=new PlansEntity();
		plansEntity.setIesUser(iesUserEntity);
		
		BeanUtils.copyProperties(plansbinding, plansEntity);
		
		return plansRepo.save(plansEntity);
	}
	
	@Override
	public List<PlansEntity>  viewAllPlans() {
		
		 return plansRepo.findAll();	
		 
	}
	

	public String readEmailBody(String filename, IesUserEntity user) {
        StringBuilder sb = new StringBuilder();
        Path path = Paths.get(filename);

        try (Stream<String> lines = Files.lines(path)) {
            lines.forEach(line -> {
                line = line.replace("${FNAME}", user.getFullName());
                line = line.replace("${TEMP_PWD}", user.getUserPwd());
                line = line.replace("${EMAIL}",user.getUserEmail());
                sb.append(line).append(System.lineSeparator());
            });
        } catch (Exception e) {
           // logger.error("Failed to read email template from {}: {}", filename, e.getMessage());
        	e.printStackTrace();
        }
        return sb.toString();
    }

	
}
