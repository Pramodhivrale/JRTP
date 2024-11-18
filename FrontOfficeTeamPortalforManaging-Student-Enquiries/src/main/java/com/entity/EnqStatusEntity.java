package com.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Enquery_Status")
public class EnqStatusEntity 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;
	
	private List<String> enqStatus;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public List<String> getEnqStatus() {
		return enqStatus;
	}

	public void setEnqStatus(List<String> enqStatus) {
		this.enqStatus = enqStatus;
	}
	
	
	
	
	
	

}
