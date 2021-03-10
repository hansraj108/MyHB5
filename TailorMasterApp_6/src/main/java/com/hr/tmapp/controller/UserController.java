package com.hr.tmapp.controller;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hr.tmapp.command.LoginCommand;
import com.hr.tmapp.command.UserCommand;
import com.hr.tmapp.domain.User;
import com.hr.tmapp.exception.UserBlockedException;
import com.hr.tmapp.service.UserService;

@Controller
public class UserController {

	
	@Autowired
	private UserService userService;
	
	private static final Logger logger = Logger.getLogger(UserController.class);
	
	@RequestMapping(value = {"/","/index"}, method = RequestMethod.GET)
	public String index(Model m) {
		logger.debug("==============> {\"/\",\"/index\"} + index + index <==============");
		m.addAttribute("command", new LoginCommand());
		return "index";
	}
	
	@RequestMapping(value = "/reg_form")
	public String registrationForm(Model m) {
		logger.debug("==============> /reg_form + registrationForm + reg_form <==============");
		
		m.addAttribute("command", new UserCommand());
		return "reg_form";
	}
	
	@RequestMapping(value = "/register")
	public String registerUser(@ModelAttribute("command") UserCommand cmd, Model m) {
		logger.debug("==============> /register + registerUser + redirect:index?act=reg <==============");
		
		try {
			User user = cmd.getUser();
			user.setLoginStatus(UserService.LOGIN_STATUS_ACTIVE);
			user.setRole(UserService.ROLE_USER);
			userService.register(user);
			
			return "redirect:index?act=reg";
		} catch (DuplicateKeyException ex) {
			// TODO Auto-generated catch block
			m.addAttribute("err", "Username is already registered");
			ex.printStackTrace();
			return "reg_form";
		}
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String handleLogin(@ModelAttribute("command") LoginCommand cmd, Model m, HttpSession session) {
		logger.debug("==============> /login + handleLogin + redirect:admin/dashboard / redirect:user/dashboard <==============");
		
		try {
			User loggedInUser =userService.loginUser(cmd.getLoginName(), cmd.getPassword());
			if(loggedInUser==null) {
				m.addAttribute("err", "Enter valid credentials");
				return "index";
			}else {
				if(loggedInUser.getRole().equals(UserService.ROLE_ADMIN)){
					addUserInSession(loggedInUser, session);
					return "redirect:admin/dashboard";
				}else if(loggedInUser.getRole().equals(UserService.ROLE_USER)){
					addUserInSession(loggedInUser, session);
					return "redirect:user/dashboard";
				}else {
					m.addAttribute("err", "Invalid User Role");
				}
			}
			
		} catch (UserBlockedException ex) {
			m.addAttribute("err", ex.getMessage());
			ex.printStackTrace();
			return "index";
		}
		
		return "index";
	}
	private void addUserInSession(User u, HttpSession session) {
		logger.debug("==============> - + addUserInSession + - <==============");
		
		session.setAttribute("user", u);
		session.setAttribute("userId", u.getUserId());
		session.setAttribute("role", u.getRole());
	}
	
	@RequestMapping(value = "/user/dashboard")
	public String userDashboard() {
		logger.debug("==============> /user/dashboard + userDashboard + dashboard_user <==============");
		
		return "dashboard_user";
	}
	
	@RequestMapping(value = "/logout")
	public String logout(HttpSession session) {
		logger.debug("==============> /logout + logout + redirect:index?act=lo <==============");
		
		session.invalidate();
		return "redirect:index?act=lo";
	}
}
