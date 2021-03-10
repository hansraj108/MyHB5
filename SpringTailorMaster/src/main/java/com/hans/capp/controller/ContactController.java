package com.hans.capp.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.hans.capp.domain.Contact;
import com.hans.capp.domain.User;
import com.hans.capp.service.ContactService;

@Controller
public class ContactController {

	@Autowired
	private ContactService contactService;
	
	@RequestMapping(value= {"/user/contact_form"})
	public String contactForm(Model m) {
		m.addAttribute("command", new Contact());
		return "contact_form";
	}
	
	@RequestMapping(value= {"/user/save_contact"})
	public String saveOrUpdateContact(@ModelAttribute("command") Contact contact,Model m, HttpSession session) {
		Integer contactId = (Integer) session.getAttribute("aContactId");
		
		if(contactId == null) {
			try {
				Integer userId = (Integer) session.getAttribute("userId");
				contact.setUserId(userId);
				contactService.save(contact);
				return "redirect:clist?act=sv";
			} catch (Exception e) {
				m.addAttribute("err","Failed to save contact");
				e.printStackTrace();
				return "contact_form";
			}
		} else {
			try {
				contact.setContactId(contactId);
				contactService.update(contact);
				return "redirect:clist?act=ed";
			} catch (Exception e) {
				m.addAttribute("err","Failed to update contact");
				e.printStackTrace();
				return "contact_form";
			}
		}
	}
	@RequestMapping(value= {"/user/clist"})
	public String contactList(Model m, HttpSession session) {
		Integer userId = (Integer) session.getAttribute("userId");
		m.addAttribute("contactList",contactService.findUserContact(userId));
		return "clist";
	}
	
	@RequestMapping(value= {"/user/edit_contact"})
	public String prepareEditForm(@RequestParam("cid") Integer contactId, Model m, HttpSession session) {

		session.setAttribute("aContactId", contactId);
		Contact c = contactService.findById(contactId);
		m.addAttribute("command", c);
		
		return "contact_form";
	}
	
	@RequestMapping(value= {"/user/del_contact"})
	public String deleteContact(@RequestParam("cid") Integer contactId) {
		contactService.delete(contactId);
		
		return "redirect:clist?act=del";
	}
	
	@RequestMapping(value= {"/user/contact_search"})
	public String contactSearch(Model m, HttpSession session, @RequestParam("freeText") String freeText) {
		Integer userId = (Integer) session.getAttribute("userId");
		m.addAttribute("contactList",contactService.findUserContact(userId,freeText));
		return "clist";
	}
	
	@RequestMapping(value= {"/user/bulk_cdelete"})
	public String deleteBulkContact(@RequestParam("cid") Integer[] contactIds) {
		contactService.deleteAll(contactIds);
		
		return "redirect:clist?act=del";
	}
	
	@RequestMapping(value = "/contactList", method=RequestMethod.GET)
	public ModelAndView getUserLists(HttpSession session) {
		Integer userId = (Integer) session.getAttribute("userId");
		ModelAndView mav = new ModelAndView();
		List<Contact> contacts = contactService.findUserContact(userId);
		mav.addObject("contacts", contacts);
		mav.setViewName("contactsview");
		return mav;
	}
}
