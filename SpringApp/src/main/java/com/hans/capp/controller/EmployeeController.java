package com.hans.capp.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	
	@RequestMapping(method= RequestMethod.GET)
	public ModelAndView showEmployeeForm() {
		Employee employee = new Employee();
		
		ModelAndView mv = new ModelAndView("employee");
		
		
		List<String> availableHobbies1 = new ArrayList<String>();
		availableHobbies1.add("e1");
		availableHobbies1.add("e2");
		employee.setHobbies(availableHobbies1);
		List<String> availableHobbies = new ArrayList<String>();
		availableHobbies.add("Reading");
		availableHobbies.add("Dancing");
		availableHobbies.add("Singing");
		availableHobbies.add("Doing Nothing");
		mv.addObject("availableHobbies", availableHobbies);
		mv.addObject("employee", employee);
		
		
		
		Map<String,String> availableSocialProfiles = new HashMap<String, String>();
		availableSocialProfiles.put("linkedin", "LinkedIN");
		availableSocialProfiles.put("facebook", "FaceBook");
		availableSocialProfiles.put("twitter", "Twitter");
		availableSocialProfiles.put("google+", "Google Plus");
		mv.addObject("availableSocialProfiles", availableSocialProfiles);

		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String submitForm(Model model, Employee employee,
			BindingResult result) {

		model.addAttribute("employee", employee);
		return "success";

	}

}
