package com.nt.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.nt.beans.RegistrationBean;

@Controller
public class MVC_Controller {

	@RequestMapping("/dispForm")
	public ModelAndView initializeForm() {
		return new ModelAndView("SpringMVC_TextBoxExample","rb", new RegistrationBean() );
	}
	
	@RequestMapping(value="/check",method=RequestMethod.POST)
	public String processForm(@Valid @ModelAttribute("rb")RegistrationBean rb,BindingResult result)
	{
		if(result.hasErrors())
		{
			return "SpringMVC_TextBoxExample";
		}
		else
		{
			rb.getFirstName();
			return "success";
		}
		
	}
}
