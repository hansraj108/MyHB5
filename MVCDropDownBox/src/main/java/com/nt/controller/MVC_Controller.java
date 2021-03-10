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

import com.nt.beans.DropDownBean;

@Controller
public class MVC_Controller {
	
	ModelAndView mav = null;
	@ModelAttribute("countryList")
	public List getCountry()
	{
		List countryList = new ArrayList();
		countryList.add("India");
		countryList.add("Australia");
		countryList.add("England");
		return countryList;
	}

	@RequestMapping("/DropDownExample")
	public String dispForm(Map model)
	{
		DropDownBean db = new DropDownBean();
		model.put("db",db);
		return "SpringMVC_DropdownExample";
		
	}
	
	@RequestMapping("/processCountry")
	public String processForm(@Valid @ModelAttribute("db") DropDownBean db1,BindingResult result)
	{
		if(result.hasErrors())
		{
			System.out.println("Validation Failed");
			return "SpringMVC_DropdownExample";
		}
		else
		{
			System.out.println("Validated Successfully");
			return "dropdown_Success";
		}
	}
}
