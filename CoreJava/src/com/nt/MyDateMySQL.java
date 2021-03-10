package com.nt;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Scanner;



public class MyDateMySQL {
	public static void main(String args[]) throws ClassNotFoundException, SQLException{  
		Date date = new Date(0);
		Scanner sc = null;
		int no=0;
		String name=null, dob=null, doj=null;
		SimpleDateFormat sdf = null;
		java.util.Date udob = null;
		java.sql.Date sqdob = null, sqdoj = null;
		long ms=0;
		Connection con=null;
		PreparedStatement ps =null;
		int result = 0;
		Statement st = null;
		ResultSet rs = null;
		
		
			
			sc = new Scanner(System.in);
					
					Class.forName("com.mysql.jdbc.Driver");  
					con=DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","tiger");  
					String query = "insert into emp1 (id,dob) values (?,?)"; 
					//here sonoo is database name, root is username and password  
					
					ps=con.prepareStatement(query);
					ps.setInt(1,5);
					java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getDate());
					ps.setDate(2, sqlDate);
					result = ps.executeUpdate();
					
					st=con.createStatement();
					rs = st.executeQuery("select id,dob from emp1");
					
						while(rs.next()){
							System.out.println(rs.getInt(1)+" "+rs.getDate(2));
						
							
					}
						
		
		}  
}
