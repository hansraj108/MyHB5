package com.hans.capp.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.hans.capp.domain.User;

import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class PdfView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		@SuppressWarnings("unchecked")
		List<User> users = (List<User>) model.get("users");
		
		PdfPTable table = new PdfPTable(6);
		table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
		table.getDefaultCell().setVerticalAlignment(Element.ALIGN_MIDDLE);
		
		
		table.addCell("userId");
		table.addCell("name");
		table.addCell("phone");
		table.addCell("email");
		table.addCell("addrress");
		table.addCell("loginname");
		
		for (User user : users) {
			table.addCell(String.valueOf(user.getUserId()));
			table.addCell(user.getName());
			table.addCell(user.getPhone());
			table.addCell(user.getEmail());
			table.addCell(user.getAddress());
			table.addCell(user.getLoginName());
			
		}
		document.add(table);
		
	}

}
