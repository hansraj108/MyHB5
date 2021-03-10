package com.hans.capp.userview;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.hans.capp.domain.User;



public class UserXlsxView extends AbstractXlsxView{

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.setHeader("Content-Disposition", "attachment; filename=\"users.xlsx\"");

		@SuppressWarnings("unchecked")
		List<User> users = (List<User>) model.get("users");
		
		Sheet sheet = workbook.createSheet("Users Xlsx");
		
		Row header = sheet.createRow(0);
		header.createCell(0).setCellValue("userId");
		header.createCell(1).setCellValue("Name");
		header.createCell(2).setCellValue("phone");
		header.createCell(3).setCellValue("email");
		header.createCell(4).setCellValue("address");
		header.createCell(5).setCellValue("loginname");
		
		int rowCount = 1;
		for (User user : users) {
			Row fruitRow = sheet.createRow(rowCount++);
			fruitRow.createCell(0).setCellValue(user.getUserId());
			fruitRow.createCell(1).setCellValue(user.getName());
			fruitRow.createCell(2).setCellValue(user.getPhone());
			fruitRow.createCell(3).setCellValue(user.getEmail());
			fruitRow.createCell(4).setCellValue(user.getAddress());
			fruitRow.createCell(5).setCellValue(user.getLoginName());
		}
		
	}

}
