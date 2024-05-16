package com.data;

import java.util.List;

import jakarta.servlet.http.HttpServletResponse;

public interface ServiceInterface 
{
	public List<String> getPlaneName();
	
	public List<String> getPlanStatus();
	
	public List<CustomerDataEntity> getSearchData(SearchReqData searchReqData);
	
	public boolean getExcel(HttpServletResponse response) throws Exception;
	
	public boolean getpdf(HttpServletResponse response) throws Exception;
	

}
