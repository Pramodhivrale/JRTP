package com.entity;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.Data;


@Data
@Entity
@Table(name = "PLANS_TABLE")
public class Plans 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer planId;
	
	private String planeName;
	
	private LocalDate planStartDate;
	
	private LocalDate planEndDate;
	
	
	@PrePersist
	public void PrePersist(){
		
		if(planStartDate==null) {
			planStartDate=LocalDate.now();
		}
		if(planEndDate == null) {
			planEndDate=planStartDate.plusYears(1);
		}
		
	}
	
	private String planCategory;
	
	private String activeSwitch;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "userId")
	private IesUser iesUser;
	
	@CreationTimestamp
	private LocalDate planCreatedDate;
	
	@UpdateTimestamp
	private LocalDate planupdatedDate;
	
	
	
	

}
