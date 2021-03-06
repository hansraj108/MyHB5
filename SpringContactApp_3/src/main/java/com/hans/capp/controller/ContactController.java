package com.hans.capp.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hans.capp.domain.Contact;
import com.hans.capp.service.ContactService;

@Controller
public class ContactController {
	
	@Autowired
	private ContactService contactService;

	@RequestMapping(value= {"/user/contact_form"})
	public String contactForm(Model m) {
		Contact contact = new Contact();
		m.addAttribute("command", contact);
		return "contact_form";
	}
	
	@RequestMapping(value= {"/user/edit_contact"})
	public String prepareEditForm(Model m, HttpSession session, @RequestParam("cid") Integer contactId) {
		session.setAttribute("aContactId", contactId);
		Contact c = contactService.findById(contactId);
		m.addAttribute("command", c);
		return "contact_form";
	}
	
	@RequestMapping(value= {"/user/save_contact"})
	public String saveOrUpdate(@ModelAttribute("command") Contact contact ,Model m, HttpSession session) {
		Integer contactId = (Integer) session.getAttribute("aContactId");
		if(contactId == null) {
		try {
			Integer userId = (Integer) session.getAttribute("userId");
			contact.setUserId(userId);
			contactService.save(contact);
			return "redirect:clist?act=sv";
		} catch (Exception e) {
			m.addAttribute("err", "Failed to save contact");
			e.printStackTrace();
			return "contact_form";
		}
	}
		else {
			try {
				contact.setContactId(contactId);
				Integer userId = (Integer) session.getAttribute("userId");
				contact.setUserId(userId);
				contactService.update(contact);
				return "redirect:clist?act=ed";
			} catch (Exception e) {
				m.addAttribute("err", "Failed to edit contact");
				e.printStackTrace();
				return "contact_form";
			}
		}
	}
	
	
	
	@RequestMapping(value= {"/user/clist"})
	public String contactList(Model m, HttpSession session) {
		m.addAttribute("contactList", contactService.findUserContact((Integer) session.getAttribute("userId")));
		
		return "clist";
	}
	
	@RequestMapping(value= {"/user/contact_search"})
	public String contactSearch(@RequestParam("freeText") String text,Model m, HttpSession session) {
		Integer userId = (Integer) session.getAttribute("userId");
		m.addAttribute("contactList", contactService.findUserContact(userId, text));
		
		
		return "clist";
	}
	
	@RequestMapping(value= {"/user/del_contact"})
	public String deleteContact(@RequestParam("cid") Integer contactId) {
		contactService.delete(contactId);
		
		return "redirect:clist?act=del";
	}
	
	
	
	@RequestMapping(value= {"/user/bulk_cdelete"})
	public String deleteBulkContact(@RequestParam("cid") Integer[] contactIds) {
		contactService.deleteAll(contactIds);
		
		return "redirect:clist?act=del";
	}
	
}
