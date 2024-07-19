package com.entity;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "citizen_data")
public class ArEntity 
{
	@Id
	private Long caseNo;
	
	private String citizenName;
	
	private String citizenEmail;
	
	private Long citizenPhoneNo;
	
	private LocalDate citizenDob;
	
	private Long citizenSsn;
	
	private String citizenState;
	
	private String citizenCity;
	
	private String citizenHouse;
	
	private String citizenBankName;
	
	private Long citizenBankAccountNo;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "userId")
	private IesUserEntity iesUser;
	
	@OneToOne()
	@JoinColumn(name = "planId")
	private PlansEntity plans;
	
	@CreationTimestamp
	private String createdDate;

}
