package com.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "loan_table")
public class LoanEntity 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer loanId;
	
	private String loanName;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "customerId")
	private CustomerEntity customerEntity;

}
