package com.entity;

import java.time.Year;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class EdcutionEntity 
{
	@Id
	private Integer educationId;
	
	private String higestDegree;
	
	private Year graduatioYear;
	
	private String university;
	
	@OneToOne
	@JoinColumn(name = "caseNo")
	private CitizenDetails citizenDetails;
	
//	 education_id		PK
//	   highest_degree
//	   graduation_year
//	   university
//	   case_num  
	

}
