package com.data;

import java.io.File;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.lowagie.text.Document;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfTable;
import com.lowagie.text.pdf.PdfWriter;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;

@Service
public class ServiceClass implements ServiceInterface {

	@Autowired
	private RepositoryInterface repository;
	
	@Autowired
	private ExcelGenretor excelGenretor;
	
	@Autowired
	private PdfGenretor pdfGenretor;
	
	@Autowired
	private EmailUtils emailUtils;

	@Override
	public List<String> getPlaneName() {
		List<String> planName = repository.getByPlanName();
		return planName;
	}

	@Override
	public List<String> getPlanStatus() {
		return repository.getByPlanStatus();
	}

	@SuppressWarnings("unlikely-arg-type")
	@Override
	public List<CustomerDataEntity> getSearchData(SearchReqData searchReqData) {
		System.out.println(searchReqData);
		CustomerDataEntity cEntity = new CustomerDataEntity();
		
		if (null != searchReqData.getPlanName() && !"".equals(searchReqData.getPlanName())) {

			cEntity.setPlanName(searchReqData.getPlanName());
		}
		if (null != searchReqData.getPlanStatus() && !"".equals(searchReqData.getPlanStatus())) {
			cEntity.setPlanStatus(searchReqData.getPlanStatus());
		}
		if (null != searchReqData.getGender() && !"".equals(searchReqData.getGender())) {
			cEntity.setGender(searchReqData.getGender());
		}
		if(null != searchReqData.getPlanStartDate() && !"".equals(searchReqData.getPlanStartDate()))
		{
			cEntity.setPlanStartDate(searchReqData.getPlanStartDate());
		}
		if(null != searchReqData.getPlanEndDate() && !"".equals(searchReqData.getPlanEndDate())) {
			cEntity.setPlanEndDate(searchReqData.getPlanEndDate());
		}
		
		return repository.findAll(Example.of(cEntity));
	}

	@Override
	public boolean getExcel(HttpServletResponse response) throws Exception 
	{
		File f=new File("plans.xls");
		List<CustomerDataEntity> all = repository.findAll();
		excelGenretor.excelGenretro(all,response,f);
		
		String subject="test mail subject";
		String body="<h2>Data</h2>";
		String to="hivralepramod4@gmail.com";
		
		
		
		emailUtils.sendemail(subject, body, to,f);
		
		f.delete();
		
		return true;
	}

	@Override
	public boolean getpdf(HttpServletResponse response) throws Exception {
		List<CustomerDataEntity> all = repository.findAll();
		pdfGenretor.pdfCreator(all,response);
		
		return true;
	}

}
