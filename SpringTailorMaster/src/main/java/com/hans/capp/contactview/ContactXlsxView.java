package com.hans.capp.contactview;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.hans.capp.domain.Contact;
import com.hans.capp.domain.User;



public class ContactXlsxView extends AbstractXlsxView{

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.setHeader("Content-Disposition", "attachment; filename=\"contacts.xlsx\"");

		@SuppressWarnings("unchecked")
		List<Contact> contacts = (List<Contact>) model.get("contacts");
		
		Sheet sheet = workbook.createSheet("Contacts Xlsx");
		
		Row header = sheet.createRow(0);
		header.createCell(0).setCellValue("userId");
		header.createCell(0).setCellValue("contactId");
		header.createCell(1).setCellValue("Name");
		header.createCell(2).setCellValue("phone");
		header.createCell(3).setCellValue("email");
		header.createCell(4).setCellValue("address");
		header.createCell(5).setCellValue("remark");
		
		int rowCount = 1;
		for (Contact contact : contacts) {
			Row fruitRow = sheet.createRow(rowCount++);
			fruitRow.createCell(0).setCellValue(contact.getUserId());
			fruitRow.createCell(1).setCellValue(contact.getContactId());
			fruitRow.createCell(2).setCellValue(contact.getName());
			fruitRow.createCell(3).setCellValue(contact.getPhone());
			fruitRow.createCell(4).setCellValue(contact.getEmail());
			fruitRow.createCell(5).setCellValue(contact.getAddress());
			fruitRow.createCell(6).setCellValue(contact.getRemark());
		}
		
	}

}
