package com.data;

import java.time.LocalDate;

public class SearchReqData 
{
	private String planName;
	private String planStatus;
	private String gender;
	private LocalDate planStartDate;
	private LocalDate planEndDate;
	
	public String getPlanName() {
		return planName;
	}
	public void setPlanName(String planName) {
		this.planName = planName;
	}
	public String getPlanStatus() {
		return planStatus;
	}
	public void setPlanStatus(String planStatus) {
		this.planStatus = planStatus;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public LocalDate getPlanStartDate() {
		return planStartDate;
	}
	public void setPlanStartDate(LocalDate planStartDate) {
		this.planStartDate = planStartDate;
	}
	public LocalDate getPlanEndDate() {
		return planEndDate;
	}
	public void setPlanEndDate(LocalDate planEndDate) {
		this.planEndDate = planEndDate;
	}
	@Override
	public String toString() {
		return "SearchReqData [planName=" + planName + ", planStatus=" + planStatus + ", gender=" + gender
				+ ", planStartDate=" + planStartDate + ", planEndDate=" + planEndDate + "]";
	}
	
	

}
