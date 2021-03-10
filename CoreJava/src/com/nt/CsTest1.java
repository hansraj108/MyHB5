package com.nt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

import com.mysql.cj.jdbc.CallableStatement;

public class CsTest1 {
	   private static final String  CALL_PROCEDURE="{ CALL  P_FIRST_PRO(?,?)}";
		public static void main(String[] args) {
			Scanner sc=null;
			int no=0;
			Connection con=null;
			java.sql.CallableStatement cs=null;
			int result=0;
			try {
				//read inputs
				sc=new Scanner(System.in);
				if(sc!=null) {
					System.out.println("Enter number::");
					no=sc.nextInt();
				}
				//register JDBC driver s/w
				   Class.forName("com.mysql.jdbc.Driver");
				   //Establish the connection
				   con=DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","tiger");
				//create CallableStatement object
				if(con!=null)
					cs=con.prepareCall(CALL_PROCEDURE);
				//register OUT params with JDBC Data types
				if(cs!=null) 
					cs.registerOutParameter(2, Types.INTEGER);
				//set values to IN params
				if(cs!=null)
					cs.setInt(1,no);
				//execute the PL/SQL procedure
				if(cs!=null)
					cs.execute();
				//gather results from OUT params
				if(cs!=null)
					result=cs.getInt(2);
				System.out.println("Square value ::"+result);
			}//try
			catch(SQLException se) {
				se.printStackTrace();
			}
			catch(ClassNotFoundException cnf) {
				cnf.printStackTrace();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			finally {
				//close jdbc objs
				try {
					if(cs!=null)
						cs.close();
				}
				catch(SQLException se) {
					se.printStackTrace();
				}
				try {
					if(con!=null)
						con.close();
				}
				catch(SQLException se) {
					se.printStackTrace();
				}
				try {
					if(sc!=null)
						sc.close();
				}
				catch(Exception e) {
					e.printStackTrace();
				}
			}//finally
		}//main
	}//class

