package com.hr.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.hr.bean.User;
import com.mysql.cj.xdevapi.Statement;

public class UserDAO {

private Connection con = null;
private PreparedStatement ps = null;
private PreparedStatement ps1 = null;
private static final String USER_INSERT = "INSERT INTO USERSERVLETDATE (DATE, NAME, ADDRESS, MARRIED, DESIGNATION, HOBIES, GENDER) VALUES (?,?,?,?,?,?,?)";
private static final String USER_INSERT_MASTER = "INSERT INTO USERSERVLETDATEMASTER (UserID,MARRIED, DESIGNATION) VALUES (?,?,?)";
//private static final int RETURN_GENERATED_KEYS=0;	
	
	
	public int insertUser(User u) throws Exception {
		System.out.println("insertUser");
		con = getPooledConnection();
		java.sql.Statement stmt = con.createStatement();
		ps = con.prepareStatement(USER_INSERT,stmt.RETURN_GENERATED_KEYS);
		ps1 = con.prepareStatement(USER_INSERT_MASTER);
		Date date;
		int result = 0;
		// tx = null;
		try {
		//	date = new SimpleDateFormat("yyyy-MM-dd").parse();
			
	        java.sql.Date sql = stringToSqlDate(u.getUdate());
	       ps.setDate(1,sql);
			ps.setString(2, u.getName());
			ps.setString(3, u.getAddress());
			ps.setString(4, u.getMarried());
			ps.setString(5, u.getDesignation());
			ps.setString(6, u.getHobies());
			ps.setString(7, u.getGender());
			
			result = ps.executeUpdate();
			ResultSet res = ps.getGeneratedKeys();
		      System.out.println("Auto-incremented values of the column ID generated by the current PreparedStatement object: ");
		     int userId = 0;
		      while (res.next()) {
		         System.out.println(res.getInt(1));
		         userId = res.getInt(1);
		      }
			System.out.println("=====>"+sql);
			
			ps1.setInt(1, userId);
			ps1.setString(2, u.getMarried());
			ps1.setString(3, u.getDesignation());
			ps1.executeUpdate();
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	//	java.util.Date dateOfJoin= format.parse( );
	//	ps.setDate(1, new java.sql.Date(date.getTime()));
		
	}
	
	//String date to SQL date
	private static java.sql.Date stringToSqlDate(String date) throws ParseException {
		
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        Date parsed = format.parse(date);
        System.out.println(parsed);
        java.sql.Date sql = new java.sql.Date(parsed.getTime());
        return sql;
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
