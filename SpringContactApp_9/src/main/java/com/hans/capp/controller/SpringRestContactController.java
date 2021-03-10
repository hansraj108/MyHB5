package com.hans.capp.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.hans.capp.domain.Contact;
import com.hans.capp.service.ContactService;

@RestController
@RequestMapping("/restcontact")
public class SpringRestContactController {

	@Autowired
	private ContactService contactService;
	
	@RequestMapping(value= {"/user/contact_form"})
	public String contactForm(Model m) {
		m.addAttribute("command", new Contact());
		return "contact_form";
	}
	
	@RequestMapping(value= {"/user/save_contact"},method=RequestMethod.POST, consumes = "application/json")
	public void saveContact(@RequestBody Contact contact) {
		
				contactService.save(contact);
				
			} 
		
	@RequestMapping(value= {"/user/clist"})
	public String contactList(Model m, HttpSession session) {
		Integer userId = (Integer) session.getAttribute("userId");
		m.addAttribute("contactList",contactService.findUserContact(userId));
		return "clist";
	}
	
	@RequestMapping(value= {"/user/save_contact/{id}"}, method=RequestMethod.PUT, consumes = "application/json")
	public void prepareEditForm(@PathVariable("id") Integer id, @RequestBody Contact contact) {

		
		Contact c = contactService.findById(id);
		System.out.println(c.getAddress());
		
		contactService.update(contact);
		
		
		
	}
	
	@RequestMapping(value= {"/user/del_contact/{id}"},method=RequestMethod.DELETE, produces="application/json")
	public ResponseEntity<Contact> deleteContact(@PathVariable("id") Integer contactId) {
		HttpHeaders headers = new HttpHeaders();
		Contact contact = contactService.findById(contactId);
		System.out.println(contact.getAddress());
		if(contact == null) {
			return new ResponseEntity<Contact>(HttpStatus.NOT_FOUND);
		}
		contactService.delete(contactId);
		headers.add("Contact Deleted - ", String.valueOf(contactId));
		return new ResponseEntity<Contact>(contact, headers, HttpStatus.NO_CONTENT); 
		
		
		
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
