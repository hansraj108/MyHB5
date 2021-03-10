package com.nt.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nt.beans.RadioButtonBean;

@Controller
public class MVC_Controller {
	
	@ModelAttribute("countryList")
	public List getCountry()
	{
		List countryList = new ArrayList();
		countryList.add("India");
		countryList.add("England");
		countryList.add("Australia");
		countryList.add("South Africa");
		
		return countryList;
	}
	
	@RequestMapping("/RadioButtonExample")
	public ModelAndView initializeForm(Map model)
	{
		return new ModelAndView("SpringMVC_RadioButtonExample","rb",new RadioButtonBean());		
	}
	
	@RequestMapping("/processRadioButtonForm")
	public String processForm(@Valid @ModelAttribute("rb")RadioButtonBean rb,BindingResult result)
	{
		if(result.hasErrors())
		{
			System.out.println("inside error block");
			return "SpringMVC_RadioButtonExample";
		}
		else
		{
			System.out.println("inside success block");
			return "radioButton_Success";
		}
	}

}
