package com.utility;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.springframework.stereotype.Component;

import com.lowagie.text.Document;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import jakarta.servlet.http.HttpServletResponse;
import com.entity.*;
@Component
public class PdfGenretor 
{
	public void pdfCreator(List<CustomerDataEntity> all,HttpServletResponse response,File f) throws Exception
	{
        Document document=new Document(PageSize.A4);
		
		PdfWriter.getInstance(document, response.getOutputStream());
		PdfWriter.getInstance(document, new FileOutputStream(f));
		document.open();
		
		Paragraph p=new Paragraph("Citizen plan info");
		document.add(p);
		PdfPTable table=new PdfPTable(6);
		table.addCell("Id");
		table.addCell("Citizen-name");
		table.addCell("Plane-name");
		table.addCell("plane-status");
		table.addCell("plan-start-date");
		table.addCell("plane-end-date");
		
		for(CustomerDataEntity plan : all) {
			table.addCell(String.valueOf(plan.getCitizenId()));
			table.addCell(plan.getCitizenName());
			table.addCell(plan.getPlanName());
			table.addCell(plan.getPlanStatus());
			table.addCell(plan.getPlanStartDate()+"");
			table.addCell(plan.getPlanEndDate()+"");
			
		}
		document.add(table);
		
		
		document.close();
	}

}
