package com.nt.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nt.bean.RegistrationBean;
import com.nt.exception.UserDefineException;

@Controller
public class RegistrationController {

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
	
	@RequestMapping("/dispForm")
	public String displayForm(Map model)
	{
		RegistrationBean rb = new RegistrationBean();
		model.put("rb",rb);
		return "registrationForm";
}
	
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public String processRegistration(@ModelAttribute("rb") RegistrationBean rb) throws IOException
	{
		if(rb.getFirstName().length()>5)
		{
			System.out.println(rb);
			throw new IOException("IOException has occured");
		}
		if(rb.getLastName().length()>5)
		{
			System.out.println(rb);
			throw new UserDefineException("custom Exception occured" , "CustomException");
		}
		System.out.println(rb);
		return "success";
	}
}