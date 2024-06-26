package com.runner;

import java.time.LocalDate;
import com.entity.*;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import com.repo.*;
@Component
public class Runners implements ApplicationRunner
{
	@Autowired
	private RepositoryInterface repo;
	
	public void data()
	{
		System.out.println("Runners");
	}
	@Override
	public void run(ApplicationArguments args) throws Exception 
	{
		CustomerDataEntity c1=new CustomerDataEntity();
        c1.setCitizenName("Pramod");
		c1.setGender("Male");
		c1.setPlanName("Cash");
		c1.setPlanStatus("Approved");
		c1.setPlanStartDate(LocalDate.now());
		c1.setPlanEndDate(LocalDate.now().plusMonths(6));
		c1.setBenefitAmt(5000.00);
		
		CustomerDataEntity c2=new CustomerDataEntity();
        c2.setCitizenName("Mahesh");
		c2.setGender("Male");
		c2.setPlanName("Cash");
		c2.setPlanStatus("Denied");
		c2.setPlanStartDate(LocalDate.now());
		c2.setPlanEndDate(LocalDate.now().plusMonths(6));
        c2.setDenialReason("Rental income");		
        
    	CustomerDataEntity c3=new CustomerDataEntity();
        c3.setCitizenName("shivani");
		c3.setGender("Female");
		c3.setPlanName("Cash");
		c3.setPlanStatus("Terminated");
		c3.setPlanStartDate(LocalDate.now());
		c3.setPlanEndDate(LocalDate.now().plusMonths(6));
        c3.setBenefitAmt(6000.0);
        c3.setTerminatedDate(LocalDate.now());
        c3.setTreminationRsn("Employedd");
        
        CustomerDataEntity c4=new CustomerDataEntity();
        c4.setCitizenName("akash");
		c4.setGender("Male");
		c4.setPlanName("Food");
		c4.setPlanStatus("Approved");
		c4.setPlanStartDate(LocalDate.now());
		c4.setPlanEndDate(LocalDate.now().plusMonths(6));
		c4.setBenefitAmt(6000.00);
		
		CustomerDataEntity c5=new CustomerDataEntity();
        c5.setCitizenName("Gajanan");
		c5.setGender("Male");
		c5.setPlanName("Food");
		c5.setPlanStatus("Denied");
		c5.setPlanStartDate(LocalDate.now());
		c5.setPlanEndDate(LocalDate.now().plusMonths(6));
        c5.setDenialReason("Home income");		
        
    	CustomerDataEntity c6=new CustomerDataEntity();
        c6.setCitizenName("Rutika");
		c6.setGender("Female");
		c6.setPlanName("Food");
		c6.setPlanStatus("Terminated");
		c6.setPlanStartDate(LocalDate.now().minusMonths(4));
		c6.setPlanEndDate(LocalDate.now().plusMonths(6));
        c6.setBenefitAmt(6000.0);
        c6.setTerminatedDate(LocalDate.now());
        c6.setTreminationRsn("Employedd");
        
        CustomerDataEntity c7=new CustomerDataEntity();
        c7.setCitizenName("Vaibhav");
		c7.setGender("Male");
		c7.setPlanName("Medical");
		c7.setPlanStatus("Approved");
		c7.setPlanStartDate(LocalDate.now());
		c7.setPlanEndDate(LocalDate.now().plusMonths(6));
		c7.setBenefitAmt(9000.00);
		
		CustomerDataEntity c8=new CustomerDataEntity();
        c8.setCitizenName("Mahesh");
		c8.setGender("Male");
		c8.setPlanName("Medical");
		c8.setPlanStatus("Denied");
		c8.setPlanStartDate(LocalDate.now());
		c8.setPlanEndDate(LocalDate.now().plusMonths(6));
        c8.setDenialReason("Illigal income");		
        
    	CustomerDataEntity c9=new CustomerDataEntity();
        c9.setCitizenName("Sanavi");
		c9.setGender("Female");
		c9.setPlanName("Medical");
		c9.setPlanStatus("Terminated");
		c9.setPlanStartDate(LocalDate.now().minusMonths(4));
		c9.setPlanEndDate(LocalDate.now().plusMonths(6));
        c9.setBenefitAmt(6000.0);
        c9.setTerminatedDate(LocalDate.now());
        c9.setTreminationRsn("Employedd");
        
        CustomerDataEntity c10=new CustomerDataEntity();
        c10.setCitizenName("Jhon");
		c10.setGender("Male");
		c10.setPlanName("Employed");
		c10.setPlanStatus("Approved");
		c10.setPlanStartDate(LocalDate.now());
		c10.setPlanEndDate(LocalDate.now().plusMonths(6));
		c10.setBenefitAmt(9000.00);
		
		CustomerDataEntity c11=new CustomerDataEntity();
		c11.setCitizenName("Shiva");
		c11.setGender("Male");
		c11.setPlanName("Medical");
		c11.setPlanStatus("Denied");
		c11.setPlanStartDate(LocalDate.now());
		c11.setPlanEndDate(LocalDate.now().plusMonths(6));
		c11.setDenialReason("not enough bank balane");		
        
    	CustomerDataEntity c12=new CustomerDataEntity();
        c12.setCitizenName("Karina");
        c12.setGender("Female");
        c12.setPlanName("Medical");
        c12.setPlanStatus("Terminated");
        c12.setPlanStartDate(LocalDate.now().minusMonths(4));
        c12.setPlanEndDate(LocalDate.now().plusMonths(6));
        c12.setBenefitAmt(6000.0);
        c12.setTerminatedDate(LocalDate.now());
        c12.setTreminationRsn("Employedd");
  		
        repo.saveAll(Arrays.asList(c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12));
        System.out.println("Data saved");
       
        	
		
		
		
	}

}
