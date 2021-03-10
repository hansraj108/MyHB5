package com.nt.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.nt.beans.RegistrationBean;

@Controller
public class MVC_Controller {
	
	/*
	@RequestMapping(value="/displayForm", method=RequestMethod.GET)
	public ModelAndView displayForm()
	{
		ModelAndView mav = new ModelAndView("registrationForm");
		RegistrationBean rb = new RegistrationBean();
		mav.addObject("rb",rb);
	
		
		return mav;
	}
	*/
	
	@RequestMapping("/displayForm")
	public String displayForm(Map model)
	{
		RegistrationBean rb = new RegistrationBean();
		model.put("rb",rb);

		
		return "registrationForm";
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
	public String processRegistration(@Valid @ModelAttribute("rb") RegistrationBean rb,BindingResult result)
	{
		if(result.hasErrors())
		{
			System.out.println(result);
			return "registrationForm";
		}
		else
		{
			System.out.println(result);
			System.out.println(rb.getFirstName());
			System.out.println(rb.getLastName());
			System.out.println(rb.getEmail());
			System.out.println(rb.getProfession());
			System.out.println("Selected Hobby");
			if(rb.getHobby()!=null)
			{
				for(String val:rb.getHobby())
				{
					System.out.print(val+"  ");
				}
			}
			return "Success";
		}
	}
}
