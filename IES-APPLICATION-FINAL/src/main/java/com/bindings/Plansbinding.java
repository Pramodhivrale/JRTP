package com.bindings;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Plansbinding 
{
	
	private String planeName;

	private String planCategory;

	private String activeSwitch;

//	@ManyToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "userId")
//	private IesUserEntity iesUser;



}
