package com.adminEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "CASEWORKERS_ACCOUNTS_DATA")
public class CaseWorkerEntity 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer caseWorkerId;
	
	private String fullName;
	
	private String emailId;
	
	private Long mobileNumber;
	
	private String gender;
	
	private String accountStatus;
	
	private Long ssnNumber;

}
