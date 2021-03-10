package com.hr.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hr.bean.UserBean;
import com.hr.dao.UserDAO;

public class UserController extends HttpServlet{

	private UserDAO userDAO;
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserBean user = new UserBean();
		user.setFirstName(req.getParameter("firstName")); 
		user.setLastName(req.getParameter("lastName"));
		user.setEmailID(req.getParameter("email"));
		user.setMobileNO(req.getParameter("mobile"));
		user.setAddress(req.getParameter("address"));
		user.setDesignation(req.getParameter("designation"));
		user.setPassword(req.getParameter("password"));
		user.setDob(req.getParameter("dob"));
		/*
		 * try { Date bod=new
		 * SimpleDateFormat("yyyy/mm/dd").parse(req.getParameter("dob"));
		 * user.setDob(bod); } catch (ParseException e) { e.printStackTrace(); }
		 */
		/*
		 * try { Date dob1 = new
		 * SimpleDateFormat("MM/dd/yyyy").parse(req.getParameter("dob"));
		 * user.setDob(dob1); } catch (ParseException e) { e.printStackTrace(); }
		 */
		
		user.setEducation(req.getParameter("education"));
		user.setFavColor(req.getParameter("favColor"));
		user.setFavWeekDay(req.getParameter("favWeek"));
		user.setMonthOfBirth(req.getParameter("birthMonth"));
		user.setTimeOfBirth(req.getParameter("birthTime"));
		/*
		 * try { Date birthMonth1 = new
		 * SimpleDateFormat("yyyy/mm/dd").parse(req.getParameter("birthMonth"));
		 * user.setMonthOfBirth(birthMonth1); } catch (ParseException e) {
		 * e.printStackTrace(); }
		 */
		/*
		 * try { Date birthTime = new
		 * SimpleDateFormat("yyyy/mm/dd").parse(req.getParameter("birthTime"));
		 * user.setTimeOfBirth(birthTime); } catch (ParseException e) {
		 * e.printStackTrace(); }
		 */
		user.setMarried(req.getParameter("married"));
		user.setGender(req.getParameter("gender"));
		user.setHobies(req.getParameter("hobies"));
		
		System.out.println(user);
		
			try {
				userDAO = new UserDAO();
				userDAO.insertUser(user);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
	}
	
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}



	
}
