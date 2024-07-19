package com.entity;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Bi_INFO {

	@Id
	private Long benefit_id	;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "caseNo")
	private ArEntity citizenDetails;
	
	private LocalDate benefit_month_year;
	
	private Double benefit_amt;
	
	private LocalDate transaction_date;
	
	private String transaction_status;
	 
}
