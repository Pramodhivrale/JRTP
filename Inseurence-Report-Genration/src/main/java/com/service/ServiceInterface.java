package com.service;


import java.util.List;

import com.entity.CustomerDataEntity;
import com.req.SearchReqData;

import jakarta.servlet.http.HttpServletResponse;

public interface ServiceInterface {
	public List<String> getPlanNames();

	public List<String> getPlanStatus();

	public List<CustomerDataEntity> getAllData(SearchReqData searchReqData);

	boolean getExcel(HttpServletResponse response) throws Exception;

	boolean getPdf(HttpServletResponse response) throws Exception;

}
