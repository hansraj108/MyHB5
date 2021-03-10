package com.nt;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class DateExample1 {

	
	public static void main(String args[]) throws ParseException {
	      //Reading name and date of birth from the user
	      Scanner sc = new Scanner(System.in);
	      
	      System.out.println("Enter your date of birth (dd-MM-yyyy): ");
	      String dob = sc.next();
	      SimpleDateFormat format = new SimpleDateFormat("ddMMyyyy");
	        Date parsed = format.parse(dob);
	        System.out.println(parsed);
	        java.sql.Date sql = new java.sql.Date(parsed.getTime());
	        System.out.println(sql);
	      
	      
	/*      
	      //Converting String to Date
	      Date date = DateExample1.StringToDate(dob);
	      System.out.println(date);
	      System.out.println(new SimpleDateFormat("MM-dd-yyyy").format(date));
	   //   java.sql.Date sql = new java.sql.Date(parsed.getTime());
	    */  
	}
	
	public static Date StringToDate(String dob) throws ParseException {
	      //Instantiating the SimpleDateFormat class
	      SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
	      //Parsing the given String to Date object
	      Date date = formatter.parse(dob);
	      System.out.println("Date object value: "+date);
	      return date;
	   }
}
