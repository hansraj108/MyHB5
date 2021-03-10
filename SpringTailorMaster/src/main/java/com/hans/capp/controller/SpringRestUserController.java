package com.hans.capp.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.hans.capp.command.LoginCommand;
import com.hans.capp.command.UserCommand;
import com.hans.capp.domain.User;
import com.hans.capp.exception.UserBlockedException;
import com.hans.capp.service.UserService;

@RestController
@RequestMapping(value="/restuser")
public class SpringRestUserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value = {"/","/index"}, method=RequestMethod.GET, produces = "application/json")
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
	
	@RequestMapping(value = "/register",  method=RequestMethod.POST)
	public void registerUser(@RequestBody User user) {
		System.out.println("===============>register");
		userService.register(user);
		System.out.println("<==========register");
			
	}
	
	@RequestMapping(value = "/check_avail")
	@ResponseBody
	public String checkAvailability(@RequestParam String username) {
		if(userService.isUsernameExists(username)) {
			return "This username is already taken";
		}else
			return "Yes, you can choose this name"; 
	}
	
	
	@RequestMapping(value = "/admin/users", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<User>> getUserList() {
		
		HttpHeaders headers = new HttpHeaders();
		List<User> userlist = userService.getUserList();
		
		 if (userlist == null) {
			   return new ResponseEntity<List<User>>(HttpStatus.NOT_FOUND);
			  }
			  headers.add("Number Of Records Found", String.valueOf(userlist.size()));
			  for(User u : userlist) {
				  System.out.println(u.getUserId());
				  System.out.println(u.getName());
				  System.out.println(u.getPhone());
				  System.out.println(u.getEmail());
				  System.out.println(u.getAddress());
				  System.out.println(u.getLoginName());
				  System.out.println(u.getLoginStatus());
				  System.out.println(u.getRole());
				  System.out.println("====================");
				  
			  }
			  return new ResponseEntity<List<User>>(userlist, headers, HttpStatus.OK);
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
	@RequestMapping(value = "/usersList", method=RequestMethod.GET,  produces = "application/json")
	public List<User> getUserLists() {
		
		List<User> users = userService.getUserList();
		
		return users;
	}
	
	@RequestMapping(value = "/userById/{id}", method=RequestMethod.GET)
	public User getUserById(@PathVariable Integer id) {
		System.out.println("==========>getUserById");
		
		User u1 = userService.findByUserId(id);
		u1.getAddress();
		return u1;
	}
	
	@RequestMapping(value= {"/deleteUser/{id}"}, method = RequestMethod.DELETE)
	public void deleteById(@PathVariable Integer id) {
		userService.deleteById(id);
	}
	
	@RequestMapping(value= {"/updateUser/{id}"}, method = RequestMethod.PUT)
	public void updateById(@RequestBody User user, @PathVariable Integer id) {
		userService.updateUser(user,id);
	}
}
