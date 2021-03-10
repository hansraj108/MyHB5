package com.nt.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nt.beans.TextAreaBean;

@Controller
public class TextArea_Controller {
	
	@RequestMapping("/TextAreaExample")
	public ModelAndView initializeForm()
	{
		System.out.println("inside");
		return new ModelAndView("SpringMVC_TextAreaExample","ta",new TextAreaBean());
	}

	@RequestMapping("/processTextAreaForm")
	public String processForm(@Valid @ModelAttribute("ta")TextAreaBean ta,BindingResult result)
	{
		if(result.hasErrors())
		{
			return "SpringMVC_TextAreaExample";
		}
		else
		{
			return "textArea_Success";
		}
	}
}
