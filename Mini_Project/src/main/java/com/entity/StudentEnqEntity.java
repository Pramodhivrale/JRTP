package com.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

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
@Table(name = "STUDENT_ENQ")
public class StudentEnqEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer enqId;

	private String studentName;

	private Long phonNo;

	private String classMode;

	private String courseName;

	private String enqStatus;

	@CreationTimestamp
	private String createdDate;

	@UpdateTimestamp
	private String updatedOn;

	@ManyToOne
	@JoinColumn(name = "userId")
	private UserDtlsEntity user;

	

	
	
	

}
