package com.hans.capp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public ModelAndView user() {
	      User user = new User();	  
		 user.setFavoriteFrameworks((new String []{"Spring MVC","Struts 2"}));
		  ModelAndView modelAndView = new ModelAndView("user", "command", user);
		  return modelAndView;
	}
	
	@ModelAttribute("webFrameworkList")
	   public List<String> getWebFrameworkList() {
	      List<String> webFrameworkList = new ArrayList<String>();
	      webFrameworkList.add("Spring MVC");
	      webFrameworkList.add("Struts 1");
	      webFrameworkList.add("Struts 2");
	      webFrameworkList.add("Apache Wicket");
	      return webFrameworkList;
	   }
}
