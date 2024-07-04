package com.adminBindings;

import java.time.LocalDate;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class PlansData {

	private String planName;

	private LocalDate planStartDate;

	private LocalDate planEndDate;
	
	private String activeSW;

}
