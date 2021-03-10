package com.hr.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import com.hr.model.UserDetails;

public class XlsView extends AbstractXlsView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		response.setHeader("Content-Disposition", "attachment; filename=\"users.xls\"");
		
		@SuppressWarnings("unchecked")
		List<UserDetails> users = (List<UserDetails>) model.get("users");
		Sheet sheet = workbook.createSheet("Users Xls");
		
		Row header = sheet.createRow(0);
		header.createCell(0).setCellValue("First Name");
		header.createCell(1).setCellValue("Last Name");
		header.createCell(2).setCellValue("Email");
		
		int rowCount = 1;
		for (UserDetails user : users) {
			Row fruitRow = sheet.createRow(rowCount++);
			fruitRow.createCell(0).setCellValue(user.getFirstName());
			fruitRow.createCell(1).setCellValue(user.getLastName());
			fruitRow.createCell(2).setCellValue(user.getEmail());
		}
	}
}
