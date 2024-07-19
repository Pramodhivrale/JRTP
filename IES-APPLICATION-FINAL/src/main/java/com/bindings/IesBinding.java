package com.bindings;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class IesBinding {
	@JsonProperty("fullName")
	private String fullName;

	@JsonProperty("userEmail")
	private String userEmail;

	@JsonProperty("userPhno")
	private Long userPhno;

	@JsonProperty("userGender")
	private String userGender;

	@JsonProperty("userDob")
	private LocalDate userDob;

	@JsonProperty("userSsn")
	private Long userSsn;

	
	@JsonProperty("userRole")
	private Integer userRole;
}
