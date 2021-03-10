package com.hr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hr.model.DefectSeverityDetails;
import com.hr.model.Developer;

@Controller
@RequestMapping(value = "/ajax")
public class AjaxHandlingController {

	@RequestMapping(value="/getDefectCount", method=RequestMethod.POST, produces = "application/json")
	public @ResponseBody DefectSeverityDetails postEmployeeData(@RequestBody Developer developer) {
		DefectSeverityDetails defectSeverityDetails = new DefectSeverityDetails();
		defectSeverityDetails.setHigh(3);
		defectSeverityDetails.setMedium(2);
		defectSeverityDetails.setLow(8);
		return defectSeverityDetails;
	}
	
	@RequestMapping(value = "/developerDefects")
	public String showEmployeePage() {
		return "developerDefects";
	}
	
}
