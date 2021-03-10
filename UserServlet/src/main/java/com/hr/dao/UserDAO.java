package com.hr.dao;

import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.hr.bean.UserBean;

public class UserDAO {

	private Connection con = null;
	
	
	
	


	PreparedStatement ps = null;
	private static final String USER_INSERT_QUERY = "INSERT INTO USERDETAILS (FirstName, LastName, EmailID, MobileNO, Address, Designation, Password,"+
			" DOB, Education, FavColor, FavWeekDay, MonthOfBirth, TimeOfBirth, Married, Gender, Hobies) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	
	public int insertUser(UserBean u) throws Exception {
		int result = 0;
		con = getPooledConnection();
		ps = con.prepareStatement(USER_INSERT_QUERY);
		ps.setString(1, u.getFirstName());
		ps.setString(2, u.getLastName());
		ps.setString(3, u.getEmailID());
		ps.setString(4, u.getMobileNO());
		ps.setString(5, u.getAddress());
		ps.setString(6, u.getDesignation());
		ps.setString(7, u.getPassword());
		ps.setString(8, u.getDob());
		ps.setString(9, u.getEducation());
		ps.setString(10, u.getFavColor());
		ps.setString(11, u.getFavWeekDay());
		ps.setString(12, u.getMonthOfBirth());
		ps.setString(13, u.getTimeOfBirth());
		ps.setString(14, u.getMarried());
		ps.setString(15, u.getGender());
		ps.setString(16, u.getHobies());
		
		result = ps.executeUpdate();
		if(result > 0) {
			System.out.println("User saved!");
		}else {
			System.out.println("Problem accored");
		}
		return result;
	}
	
	private static java.sql.Date dateConversion(Date date){
		 // util object
	      java.util.Date utilObj = date;
	      // sql object
	      java.sql.Date sqlObj = new java.sql.Date(utilObj.getDate());
	      
	      return sqlObj;
	     
	}
	
	
	private Connection getPooledConnection() throws Exception{
		InitialContext ic=null;
		DataSource ds=null;
		Connection con=null;
		//perform Jndi lookup operation on JNDI registry
		ic=new InitialContext();
		//ds=(DataSource) ic.lookup("DsJndi");
		ds=(DataSource) ic.lookup("java:/comp/env/DsJndi");//only in tomcat server
		//get pooled Jdbc connection obj
		con=ds.getConnection();
		return con;
	}
}
