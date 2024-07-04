package com.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class DC_CHILDREN 
{
	@Id
	private Integer childId;
	
	private String childName;
	
	private LocalDate childDob;
	
	private Long childSsn;
	
	@OneToOne
	@JoinColumn(name = "caseNo")
	private CitizenDetails citizenDetails;
	
//	  child_id		PK
//      child_name	
//  child_dob
//  child_ssn
//      case_num		FK   

}
