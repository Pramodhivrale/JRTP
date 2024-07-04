package com.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class ED_ELG_DTLS {
	
	@Id
	private Long ed_trace_i;
	
	@OneToOne
	@JoinColumn(name = "caseNo")
	private CitizenDetails citizenDetails;
	
	private String plan_name;
	
	private String plan_status;
	
	private LocalDate startDate;
	
	private LocalDate endDate;
	
	private Double  benefit_amt;
	
	private String denial_reason;
	
	private String createdDate;
}
