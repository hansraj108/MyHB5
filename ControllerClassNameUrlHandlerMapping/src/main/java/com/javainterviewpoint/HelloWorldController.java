package com.javainterviewpoint;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class HelloWorldController extends AbstractController {

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		System.out.println("Inside HelloWorldController");
        ModelAndView model = new ModelAndView("helloWorld");
        model.addObject("msg", "JavaInterviewPoint");
		return model;
	}

}
