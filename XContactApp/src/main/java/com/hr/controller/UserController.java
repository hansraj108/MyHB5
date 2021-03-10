package com.hr.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hr.command.LoginCommand;
import com.hr.command.UserCommand;
import com.hr.domain.User;
import com.hr.exception.UserBlockedException;
import com.hr.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;

	@RequestMapping(value = {"/", "/index"})
    public String index(Model m) {
        m.addAttribute("command", new LoginCommand());
        return "index"; //JSP - /WEB-INF/view/index.jsp
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String handleLogin(@ModelAttribute("command") LoginCommand cmd, Model m, HttpSession session) {
        try {
            User loggedInUser = userService.login(cmd.getLoginName(), cmd.getPassword());
            if (loggedInUser == null) {
                //FAILED
                //add error message and go back to login-form
                m.addAttribute("err", "Login Failed! Enter valid credentials.");
                return "index";//JSP - Login FORM
            } else //SUCCESS
            //check the role and redirect to a appropriate dashboard 
            {
                if (loggedInUser.getRole().equals(UserService.ROLE_ADMIN)) {
                    //add user detail in session (assign session to logged in user)
                     return "redirect:admin/dashboard";
                } else if (loggedInUser.getRole().equals(UserService.ROLE_USER)) {
                    //add user detail in session (assign session to logged in user)
                   return "redirect:user/dashboard";
                } else {
                    //add error message and go back to login-form
                    m.addAttribute("err", "Invalid User ROLE");
                    return "index";//JSP - Login FORM
                }
            }
        } catch (UserBlockedException ex) {
            //add error message and go back to login-form
            m.addAttribute("err", ex.getMessage());
            return "index";//JSP - Login FORM
        }
    }

    
    @RequestMapping(value = "/user/dashboard")
    public String userDashboard() {
        return "dashboard_user"; //JSP
    }

    @RequestMapping(value = "/admin/dashboard")
    public String adminDashboard() {
        return "dashboard_admin"; //JSP
    }

    @RequestMapping(value = "/admin/users")
    public String getUserList(Model m) {
        m.addAttribute("userList", userService.getUserList());
        return "users"; //JSP
    }

    @RequestMapping(value = "/reg_form")
    public String registrationForm(Model m) {
        UserCommand cmd = new UserCommand();
        m.addAttribute("command", cmd);
        return "reg_form";//JSP
    }

    @RequestMapping(value = "/register")
    public String registerUser(@ModelAttribute("command") UserCommand cmd, Model m) {
        try {
			User user = cmd.getUser();
			user.setRole(userService.ROLE_USER);
			user.setLoginStatus(userService.LOGIN_STATUS_ACTIVE);
			userService.register(user);
			return "redirect:index?act=reg";
		} catch (Exception e) {
			m.addAttribute("err", "Username is already registered. Please select another username.");
			e.printStackTrace();
			return "reg_form";
		}
        }
    }
