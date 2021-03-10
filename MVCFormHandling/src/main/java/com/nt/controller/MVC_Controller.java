package com.nt.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.nt.beans.RegistrationBean;

@Controller
public class MVC_Controller {
	
	@ModelAttribute("professionList")
	public List professionalList() {
		
		List professionList = new ArrayList();
		professionList.add("Developer");
		professionList.add("Manager");
		professionList.add("architect");
		
		return professionList;
		
	}
	
	
	
	@RequestMapping(value="/displayForm", method=RequestMethod.GET)
	public ModelAndView welcome() {
		
		return new ModelAndView ("RegistrationForm","rb",new RegistrationBean());
	}
	
	@RequestMapping(value="/Register", method=RequestMethod.POST)
	public String processRegistration(@ModelAttribute("rb") RegistrationBean rb) {
		{
			System.out.println(rb.getName());
			return "RegistrationSuccessful";
		}
		
	}

}
