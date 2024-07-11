package com.entity;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
@Table(name = "PLANS_TABLE")
@Entity
public class PlansEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer planId;

	private String planeName;

	private LocalDate planStartDate;

	private LocalDate planEndDate;

	@PrePersist
	public void PrePersist() {

		if (planStartDate == null) {
			planStartDate = LocalDate.now();
		}
		if (planEndDate == null) {
			planEndDate = planStartDate.plusYears(1);
		}

	}

	private String planCategory;

	private String activeSwitch;

	//@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "userId")
	private IesUserEntity iesUser;

	@CreationTimestamp
	private LocalDate planCreatedDate;

	@UpdateTimestamp
	private LocalDate planupdatedDate;

}
