package com.service;

import java.util.List;
import java.util.Optional;

import com.bindings.EnquiryForm;
import com.bindings.UpdateForm;
import com.entity.StudentEnqEntity;
import com.response.DashBoardResponse;
import com.response.EnqSearchCreteria;

public interface EnquieryService 
{
	public List<String> getCourseName();
	
	public List<String> getEnqStatus();
	
	public DashBoardResponse getDashBoardResponse(Integer id);
	
	public String upseartEnquiery(EnquiryForm form);
	
	public List<StudentEnqEntity> getEnquries(Integer id);
	
	public EnquiryForm getEnq(Integer enqId);
	
	public Optional<StudentEnqEntity> editEnq(Integer id);
	
	public String  updateStudentData(Integer id,UpdateForm form);
	
	public List<StudentEnqEntity> filterEnq(Integer id, EnqSearchCreteria creteria);

}
