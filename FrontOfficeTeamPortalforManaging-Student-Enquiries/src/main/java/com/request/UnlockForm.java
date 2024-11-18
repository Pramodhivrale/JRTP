package com.request;

public class UnlockForm 
{
	private String tempPassword;
	
	private String newPassword;
	
	private String confirmPassword;
	
	private String email;

	public String getTempPassword() {
		return tempPassword;
	}

	public void setTempPassword(String tempPassword) {
		this.tempPassword = tempPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	
	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "UnlockForm [tempPassword=" + tempPassword + ", newPassword=" + newPassword + ", confirmPassword="
				+ confirmPassword + ", email=" + email + "]";
	}

	
	
	

}
