package com.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class DC_PLAN_SELECTION 
{
//	plan_selection_id PK
//	case_num
//	plan_id
	
	@Id
	private String planSelectionId;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "planId")
	private PlansEntity plans;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "caseNo")
	private CitizenDetails citizenDetails;

}
