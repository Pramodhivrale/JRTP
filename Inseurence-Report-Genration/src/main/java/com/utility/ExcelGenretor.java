package com.utility;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Component;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import com.entity.*;
@Component
public class ExcelGenretor 
{
	public void excelGenretro(List<CustomerDataEntity> all,HttpServletResponse response,File f) throws IOException
	{
		Workbook workbook =new HSSFWorkbook();
		Sheet sheet = workbook.createSheet("plans-data");
		Row row = sheet.createRow(0);
		
		row.createCell(0).setCellValue("ID");
		row.createCell(1).setCellValue("CITIZEN-NAME");
		row.createCell(2).setCellValue("PLAN-NAME");
		row.createCell(3).setCellValue("PLAN-STATUS");
		row.createCell(4).setCellValue("PLAN START DATE");
		row.createCell(5).setCellValue("PLAN END DATE");
		row.createCell(6).setCellValue("BENIFICRY AMOUNT");
		
		
		
		int datarowindex=1;
		for(CustomerDataEntity plans:all)
		{
			Row row2 = sheet.createRow(datarowindex);
			
			row2.createCell(0).setCellValue(plans.getCitizenId());
			row2.createCell(1).setCellValue(plans.getCitizenName());
			row2.createCell(2).setCellValue(plans.getPlanName());
			row2.createCell(3).setCellValue(plans.getPlanStatus());
			
			
			if(null != plans.getPlanStartDate()) {
				row2.createCell(4).setCellValue(plans.getPlanStartDate()+"");	
			}
			else {
				row2.createCell(4).setCellValue("N/A");
			}
			if(null != plans.getPlanEndDate()) {
				row2.createCell(5).setCellValue(plans.getPlanEndDate()+"");
			}
			else {
				row2.createCell(5).setCellValue("N/A");
			}
			if(null != plans.getBenefitAmt()) {
				row2.createCell(6).setCellValue(plans.getBenefitAmt());
			}
			else {
				row2.createCell(6).setCellValue("N/A");
			}
			
			
			datarowindex++;
		}
		
		//It will create file in folder of application
		FileOutputStream fileOutputStream=new FileOutputStream(new File("plans.xls"));
		workbook.write(fileOutputStream);
		fileOutputStream.close();
		
		//It will send file to browser
		ServletOutputStream outputStream = response.getOutputStream();
		workbook.write(outputStream);
		workbook.close();

	}
}
	

	
