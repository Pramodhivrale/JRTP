package com.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.entity.CustomerEntity;
import com.entity.LoanEntity;
import com.repo.CustomerRepo;
import com.repo.LoanRepo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@SpringBootApplication
@ComponentScan(basePackages = "com.*")
@EnableJpaRepositories(basePackages = "com.repo")
@EntityScan(basePackages = "com.entity")
public class ManyToOneApplication {

		
	
	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(ManyToOneApplication.class, args);
	
		CustomerRepo bean = run.getBean(CustomerRepo.class);
		LoanRepo bean2 = run.getBean(LoanRepo.class);
		
		
		CustomerEntity c=new CustomerEntity();
		c.setCustName("Rutika");
		c.setCustGender("Female");
		CustomerEntity save = bean.save(c);
		
		System.out.println("Customer saved !!!");
		
		
		LoanEntity loan=new LoanEntity();
		loan.setLoanName("Hdfc");
		loan.setCustomerEntity(save);
		
		LoanEntity loan1=new LoanEntity();
		loan1.setLoanName("Kotak");
		loan1.setCustomerEntity(save);
		
		bean2.save(loan);
		bean2.save(loan1);
		
		System.out.println("Loan saved !!");
		
		
		
		
		
		
		
		
	
		
		
	  
		
	}

}
