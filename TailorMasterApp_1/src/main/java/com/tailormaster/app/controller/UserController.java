package com.tailormaster.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tailormaster.app.command.LoginCommand;
import com.tailormaster.app.service.UserService;

@Controller
public class UserController {

    
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = {"/","/index"})
	public String index(Model m) {
		System.out.println("hiiii");
		m.addAttribute("command", new LoginCommand());
		return "hi";
	}
	
	
}
