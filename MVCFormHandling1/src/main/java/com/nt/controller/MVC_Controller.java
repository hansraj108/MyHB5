package com.nt.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.nt.beans.Registration;

@Controller
public class MVC_Controller {
	
	@RequestMapping(value="DisplayForm", method=RequestMethod.GET)
	public ModelAndView welcome() {
		
		return new ModelAndView ("RegistrationPage","rb", new Registration());
	}
	
	@ModelAttribute("profession")
	public List professionList() {
		List profession = new ArrayList();
		profession.add("developer");
		profession.add("civil");
		profession.add("arch");
		return profession;
	}
	
	@RequestMapping(value="Register", method=RequestMethod.POST)
	public String processRegistration(@ModelAttribute("rb") Registration rb) {
		
		System.out.println(rb.getName());
		return "RegistrationSucess";
	}

}
