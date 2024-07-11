package com.entity;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class NoticesEntity {

	@Id
	private Long notice_id;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "caseNo")
	private CitizenDetails citizenDetails;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="ed_trace_i")
	private planEligiblity eligiblityDtls;
	
	@Lob
	private byte[] co_pdf;
	
	private LocalDate printDate;
	
	private String noticeStatus;
	
	private LocalDate createdDate;

	
}
