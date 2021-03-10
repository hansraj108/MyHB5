package com.nt.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class  FirstServlet extends javax.servlet.http.HttpServlet {

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("We are in doGet( ) method ");
		 if(req.isUserInRole("hero")) {
		 System.out.println("this is hero home page");
		 } else {
			 System.out.println("this is others home page");
		 } 

}

	
	
}
