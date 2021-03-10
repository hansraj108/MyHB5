package com.hans.capp.contactview;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.hans.capp.domain.Contact;
import com.hans.capp.domain.User;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class ContactPdfView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		@SuppressWarnings("unchecked")
		List<Contact> contacts = (List<Contact>) model.get("contacts");
		
		PdfPTable table = new PdfPTable(6);
		table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
		table.getDefaultCell().setVerticalAlignment(Element.ALIGN_MIDDLE);
		
		table.addCell("userId");
		table.addCell("cid");
		table.addCell("name");
		table.addCell("phone");
		table.addCell("email");
		table.addCell("addrress");
		table.addCell("remark");
		
		for (Contact contact : contacts) {
			table.addCell(String.valueOf(contact.getUserId()));
			table.addCell(String.valueOf(contact.getContactId()));
			table.addCell(contact.getName());
			table.addCell(contact.getPhone());
			table.addCell(contact.getEmail());
			table.addCell(contact.getAddress());
			table.addCell(contact.getRemark());
			
		}
		document.add(table);
		
	}

}
