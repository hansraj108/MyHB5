package com.nt.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.nt.beans.RegistrationBean;

@Controller
public class RegistrationController {

	@RequestMapping("/dispForm")
	public String displayForm(Map model)
	{
		RegistrationBean rb = new RegistrationBean();
		model.put("rb",rb);
		return "RegistrationForm";
	}
	
	@ModelAttribute("professionList")
	public List populateProfessionList()
	{
		List professionList = new ArrayList(); 
		professionList.add("Devloper");
		professionList.add("Manager");
		professionList.add("Architecht");
		
		return professionList;
	}
	
	@ModelAttribute("hobbyList")
	public List populateHobbyList()
	{
		List hobbyList = new ArrayList(); 
		hobbyList.add("Cricket");
		hobbyList.add("Football");
		hobbyList.add("Hockey");
		hobbyList.add("Basketball");
		
		return hobbyList;
	}
	
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public String processRegistration(@ModelAttribute("rb") RegistrationBean rb) throws IOException
	{
		if(rb.getFirstName().length()>5)
		{
			throw new IOException("IOException has occured");
		}
		return "Success";
	}
	@ExceptionHandler(IOException.class)
	public ModelAndView  processException(IOException ioe)
	{
		ModelAndView mav = new ModelAndView("ExceptionPage");
		 mav.addObject("name", ioe.getClass().getSimpleName());
	     mav.addObject("message", ioe.getMessage());
	 
	     return mav;
	}
}
