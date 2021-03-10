package com.hr.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hr.bean.User;
import com.hr.dao.UserDAO;

public class UserController extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UserDAO userDAO;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doGet");
		int result = 0;
		PrintWriter pw = resp.getWriter();
		User u = new User();
		u.setUdate(req.getParameter("date"));
		u.setName(req.getParameter("uname"));
		u.setGender(req.getParameter("gender"));
		u.setAddress(req.getParameter("address"));
		u.setDesignation(req.getParameter("designation"));
		u.setHobies(req.getParameter("hobies"));
		u.setMarried(req.getParameter("married"));
		System.out.println(u);
		System.out.println(u.getUdate());
		
		try {
			userDAO = new UserDAO();
		 result	= userDAO.insertUser(u);
		 if(result>0) {
			 pw.println("Inserted");
		 } else {
			 pw.println("Not Inserted");
		 }
		
		 RequestDispatcher dispatcher = req.getRequestDispatcher("index.jsp");
		 
	        dispatcher.forward(req, resp);
	        pw.close();
		 
		 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req,resp);
	}
	
	
	

}
