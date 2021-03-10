package com.javainterviewpoint;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class WelcomeController extends AbstractController{

	int count=1;
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		HttpSession session=request.getSession();  
      //  session.setAttribute("uname",count);
		System.out.println("Inside WelcomeController "+count++);

        ModelAndView model = new ModelAndView("welcome");
        model.addObject("msg", "JavaInterviewPoint");
        
        return model;
	}

}
