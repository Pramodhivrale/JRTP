package com.bindings;

import lombok.Data;

@Data
public class UnlockBinding 
{
	private String userEmail;
	
	private String tempPwd;
	
	private String newPwd;
	
	private String confirmPwd;

}
