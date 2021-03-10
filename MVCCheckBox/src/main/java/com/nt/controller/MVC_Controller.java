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

import com.nt.beans.CheckboxBean;

@Controller
public class MVC_Controller {
	
	ModelAndView mav = null;
	@ModelAttribute("favouriteList")
	public List getFavouriteSports()
	{
		List favouriteList = new ArrayList();
		favouriteList.add("Football");
		favouriteList.add("Cricket");
		favouriteList.add("Hockey");
		return favouriteList;
	}
	
	@RequestMapping("/CheckboxExample")
	public String initializeForm(Map model)
	{
		CheckboxBean cb = new CheckboxBean();
		model.put("cb",cb);
		return "SpringMVC_CheckboxExample";
		
	}
	
	@RequestMapping("/processCheckbox")
	public String processForm(@Valid @ModelAttribute("cb") CheckboxBean cb,BindingResult result)
	{
		if(result.hasErrors())
		{
			System.out.println("Validation Failed");
			
			System.out.println(">>>>"+cb.getFavourite());
			return "SpringMVC_CheckboxExample";
		}
		else
		{
			System.out.println("Validated Successfully");
			System.out.println(">>>>"+cb.getFavourite());
			return "checkbox_Success";
		}
	}

}
