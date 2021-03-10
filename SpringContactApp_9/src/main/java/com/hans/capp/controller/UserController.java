package com.hans.capp.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamSource;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.hans.capp.command.LoginCommand;
import com.hans.capp.command.UserCommand;
import com.hans.capp.domain.User;
import com.hans.capp.exception.UserBlockedException;
import com.hans.capp.service.UserService;

@Controller
public class UserController {

	static String emailToRecipient, emailSubject, emailMessage;
    static final String emailFromRecipient = "hrtandel8@gmail.com";
 
    static ModelAndView modelViewObj;
    
    @Autowired
    private JavaMailSender mailSenderObj;
    
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = {"/","/index"})
	public String index(Model m) {
		m.addAttribute("command", new LoginCommand());
		return "index";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String handleLogin(@ModelAttribute("command") LoginCommand cmd, Model m, HttpSession session) {
		
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
		session.setAttribute("user", u);
		session.setAttribute("userId", u.getUserId());
		session.setAttribute("role", u.getRole());
	}
	
	@RequestMapping(value = "/user/dashboard")
	public String userDashboard() {
		return "dashboard_user";
	}
	
	@RequestMapping(value = "/admin/dashboard")
	public String adminDashboard() {
		return "dashboard_admin";
	}
	
	@RequestMapping(value = "/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:index?act=lo";
	}
	
	@RequestMapping(value = "/reg_form")
	public String registrationForm(Model m) {
		m.addAttribute("command", new UserCommand());
		
		return "reg_form";
	}
	
	@RequestMapping(value = "/register")
	public String registerUser(@ModelAttribute("command") UserCommand cmd, Model m) {
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
	
	@RequestMapping(value = "/check_avail")
	@ResponseBody
	public String checkAvailability(@RequestParam String username) {
		if(userService.isUsernameExists(username)) {
			return "This username is already taken";
		}else
			return "Yes, you can choose this name"; 
	}
	
	@RequestMapping(value = "/admin/users")
	public String getUserList(Model m) {
		m.addAttribute("usersList", userService.getUserList());
		return "users";
	}
	
	@RequestMapping(value = "/admin/change_status")
	@ResponseBody
	public String changeLoginStatus(@RequestParam Integer userId, @RequestParam Integer loginStatus) {
		try {
			userService.changeLoginStatus(userId, loginStatus);
			return "SUCCESS: Status Changed";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "ERROR: Unable to Change Status";
		}
	}
	@RequestMapping(value = "/usersList", method=RequestMethod.GET)
	public ModelAndView getUserLists() {
		ModelAndView mav = new ModelAndView();
		List<User> users = userService.getUserList();
		mav.addObject("users", users);
		mav.setViewName("usersview");
		return mav;
	}
	
	@RequestMapping(value = "/sendEmail", method=RequestMethod.GET)
	public String sendEmail() {
		return "emailForm";
	}
	
	@RequestMapping(value = "/sendEmailFormData", method=RequestMethod.POST)
	public ModelAndView sendEmailToClient(HttpServletRequest request, final @RequestParam CommonsMultipartFile attachFileObj) {
		
		    // Reading Email Form Input Parameters      
	        emailSubject = request.getParameter("subject");
	        emailMessage = request.getParameter("message");
	        emailToRecipient = request.getParameter("mailTo");
	 
	        // Logging The Email Form Parameters For Debugging Purpose
	        System.out.println("\nReceipient?= " + emailToRecipient + ", Subject?= " + emailSubject + ", Message?= " + emailMessage + "\n");
	 
	        mailSenderObj.send(new MimeMessagePreparator() {
	            public void prepare(MimeMessage mimeMessage) throws Exception {
	 
	                MimeMessageHelper mimeMsgHelperObj = new MimeMessageHelper(mimeMessage, true, "UTF-8");             
	                mimeMsgHelperObj.setTo(emailToRecipient);
	                mimeMsgHelperObj.setFrom(emailFromRecipient);               
	                mimeMsgHelperObj.setText(emailMessage);
	                mimeMsgHelperObj.setSubject(emailSubject);
	 
	                // Determine If There Is An File Upload. If Yes, Attach It To The Client Email              
	                if ((attachFileObj != null) && (attachFileObj.getSize() > 0) && (!attachFileObj.equals(""))) {
	                    System.out.println("\nAttachment Name?= " + attachFileObj.getOriginalFilename() + "\n");
	                    mimeMsgHelperObj.addAttachment(attachFileObj.getOriginalFilename(), new InputStreamSource() {                   
	                        public InputStream getInputStream() throws IOException {
	                            return attachFileObj.getInputStream();
	                        }
	                    });
	                } else {
	                    System.out.println("\nNo Attachment Is Selected By The User. Sending Text Email!\n");
	                }
	            }
	        });
	        System.out.println("\nMessage Send Successfully.... Hurrey!\n");
	        
	        modelViewObj = new ModelAndView("success","messageObj","Thank You! Your Email Has Been Sent!");
	        return  modelViewObj;
	}
}
