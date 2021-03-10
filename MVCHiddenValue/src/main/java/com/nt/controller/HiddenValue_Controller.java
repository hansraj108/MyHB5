package com.nt.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nt.beans.HiddenValueBean;

@Controller
public class HiddenValue_Controller {

	 @RequestMapping("/HiddenValueExample")
	    public String initializeForm(Map model) {
	        HiddenValueBean hb = new HiddenValueBean();
	        model.put("hb", hb);
	        return "SpringMVC_HiddenValueExample";
	    }
	 
	 @RequestMapping("/processHiddenValue")
	    public String processForm(@ModelAttribute("hb") HiddenValueBean hb) {
	        System.out.println("Validation Passed");

	    //    System.out.println(">>>>" + hb.getHiddenMessage());
	        return "hiddenvalue_Success";
	    }
	
}
