package com.hr.tmapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hr.tmapp.command.LoginCommand;

@Controller
public class UserController {

	@RequestMapping(value = {"/","/index"}, method = RequestMethod.GET)
	public String index(Model m) {
		System.out.println("hiiii");
		m.addAttribute("command", new LoginCommand());
		return "index";
	}
}
