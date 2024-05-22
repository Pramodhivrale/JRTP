package com.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "USER_DTLS")
public class UserDtlsEntity 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;

	private String userName;
	
	private String email;
	
	private String pwd;
	
	private Long phoNo;

    private String accStatus;
    
    @OneToMany(mappedBy = "user" ,cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<StudentEnqEntity> enquiries;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public Long getPhoNo() {
		return phoNo;
	}

	public void setPhoNo(Long phoNo) {
		this.phoNo = phoNo;
	}

	public String getAccStatus() {
		return accStatus;
	}

	public void setAccStatus(String accStatus) {
		this.accStatus = accStatus;
	}

	public List<StudentEnqEntity> getEnquiries() {
		return enquiries;
	}

	public void setEnquiries(List<StudentEnqEntity> enquiries) {
		this.enquiries = enquiries;
	}

	@Override
	public String toString() {
		return "UserDtlsEntity [userId=" + userId + ", userName=" + userName + ", email=" + email + ", pwd=" + pwd
				+ ", phoNo=" + phoNo + ", accStatus=" + accStatus + ", enquiries=" + enquiries + "]";
	}
    
    
	
	
	
}
