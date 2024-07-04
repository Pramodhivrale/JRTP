package com.service;


import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.entity.CustomerDataEntity;
import com.repo.RepositoryInterface;
import com.req.SearchReqData;
import com.utility.EmailUtils;
import com.utility.ExcelGenretor;
import com.utility.PdfGenretor;

import jakarta.servlet.http.HttpServletResponse;

@Service
public class ServiceClass implements ServiceInterface {

	@Autowired
	private RepositoryInterface repo;

	@Autowired
	private ExcelGenretor email;

	@Autowired
	private PdfGenretor pdfUtility;

	@Autowired
	private EmailUtils sender;

	@Override
	public List<String> getPlanNames() {
		List<String> planNames = repo.getByPlanName();
		return planNames;
	}

	@Override
	public List<String> getPlanStatus() {
		List<String> planStatus = repo.getByPlanStatus();
		return planStatus;
	}

	@Override
	public List<CustomerDataEntity> getAllData(SearchReqData searchReqData) {

		CustomerDataEntity entity = new CustomerDataEntity();

		if (null != searchReqData.getPlanName() && !"".equals(searchReqData.getPlanName())) {

			entity.setPlanName(searchReqData.getPlanName());
		}
		if (null != searchReqData.getPlanStatus() && !"".equals(searchReqData.getPlanStatus())) {
			entity.setPlanStatus(searchReqData.getPlanStatus());
		}
		if (null != searchReqData.getGender() && !"".equals(searchReqData.getGender())) {
			entity.setGender(searchReqData.getGender());
		}
		if (null != searchReqData.getPlanStartDate() && !"".equals(searchReqData.getPlanStartDate())) {
			entity.setPlanStartDate(searchReqData.getPlanStartDate());
		}
		if (null != searchReqData.getPlanEndDate() && !"".equals(searchReqData.getPlanEndDate())) {
			entity.setPlanEndDate(searchReqData.getPlanEndDate());
		}
		return repo.findAll(Example.of(entity));
	}

	@Override
	public boolean getPdf(HttpServletResponse response) throws Exception {
		File f=new File("plans.pdf");
		List<CustomerDataEntity> all = repo.findAll();
		pdfUtility.pdfCreator(all, response,f);
		
		String subject = "test mail subject";
		String body = "<h2>Data</h2>";
		String to = "hivralepramod4@gmail.com";
		
		sender.sendemail(subject, body, to,f);
		f.delete();

		return true;

	}

	@Override
	public boolean getExcel(HttpServletResponse response) throws Exception {
		File f=new File("plans.xls");
		List<CustomerDataEntity> all = repo.findAll();
		email.excelGenretro(all, response,f);

		String subject = "test mail subject";
		String body = "<h2>Data</h2>";
		String to = "hivralepramod4@gmail.com";
		
		sender.sendemail(subject, body, to,f);
		f.delete();

	

		return true;

	}

}
