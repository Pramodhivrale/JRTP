package com.bindings;

import lombok.Data;

@Data
public class DashboardPage 
{
	private Integer planCount;
	
	private Integer approvedCount;
	
	private Integer deniedCount;
	
	private Double beniftAmt;
	
	private IesBinding iesBinding;
	
	

}
