package com.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
public class DC_INCOME 
{
	
	@Id
	private Long incomeId;
	
	private Double salaryIncome;
	
	private Double rentIncome;
	
	private Double propertyIncome;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "caseNo")
	private CitizenDetails citizenDetails;


}
