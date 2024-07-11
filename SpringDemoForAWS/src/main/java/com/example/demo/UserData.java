package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "userAWSDEMO")
public class UserData {
	
	@Id
	private Integer usedId;
	
	private String userName;
	
	private String userGender;
	
	private String userDept;

	public Integer getUsedId() {
		return usedId;
	}

	public void setUsedId(Integer usedId) {
		this.usedId = usedId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserGender() {
		return userGender;
	}

	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}

	public String getUserDept() {
		return userDept;
	}

	public void setUserDept(String userDept) {
		this.userDept = userDept;
	}
	
	

}
