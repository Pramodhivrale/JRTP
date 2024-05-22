package com.service;

import java.util.List;

import com.request.EnquiryForm;
import com.response.DashBoardResponse;

public interface EnquieryService 
{
	public List<String> getCourseName();
	
	public List<String> getEnqStatus();
	
	public DashBoardResponse getDashBoardResponse(Integer id);
	
	public String upseartEnquiery(EnquiryForm form);
	
	public List<EnquiryForm> getEnquries();
	
	public EnquiryForm getEnq(Integer enqId);

}
