package com.data;

import java.util.List;

import jakarta.servlet.http.HttpServletResponse;

public interface ServiceInterface {
	public List<String> getPlanNames();

	public List<String> getPlanStatus();

	public List<EntityClass> getAllData(SearchReqData searchReqData);

	boolean getExcel(HttpServletResponse response) throws Exception;

	boolean getPdf(HttpServletResponse response) throws Exception;

}
