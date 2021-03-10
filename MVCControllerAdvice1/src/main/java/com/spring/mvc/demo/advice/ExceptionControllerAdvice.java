package com.spring.mvc.demo.advice;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.spring.mvc.demo.exception.MyException;

@ControllerAdvice
public class ExceptionControllerAdvice {

	@ExceptionHandler(MyException.class)
	public ModelAndView handleMyException(MyException mex) {
		ModelAndView model = new ModelAndView();
		model.addObject("errCode", mex.getErrCode());
		model.addObject("errMsg", mex.getErrMsg());
        model.setViewName("error/generic_error");
        return model;
	}
	
	@ExceptionHandler(Exception.class)
    public ModelAndView handleException(Exception ex) {
 
        ModelAndView model = new ModelAndView();
        model.addObject("errMsg", "This is a 'Exception.class' message.");
        model.setViewName("error/generic_error");
        return model;
 
    }
}
