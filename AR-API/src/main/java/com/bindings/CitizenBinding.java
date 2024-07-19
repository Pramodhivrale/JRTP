package com.bindings;

import java.time.LocalDate;

import lombok.Data;

@Data
public class CitizenBinding {
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
	
	

}
