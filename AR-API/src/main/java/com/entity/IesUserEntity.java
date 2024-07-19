package com.entity;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.ToString;

@ToString
@Data
@Entity
@Table(name = "IES_USER_DATA")
public class IesUserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;

	private String fullName;

	private String userEmail;

	private String userPwd;

	private Long userPhno;

	private String userGender;

	private LocalDate userDob;

	private Long userSsn;

	private String activeSwitch;

	private String userAccountStatus;

	// 1-admin
	// 2-case worker
	private Integer userRole;

//	@OneToMany(cascade = CascadeType.ALL, mappedBy = "iesUser")
//	private List<Plans> plans;

	@CreationTimestamp
	private LocalDate createdAt;

	@UpdateTimestamp
	private LocalDate updatedAt;

}
