package com.nt;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class MyDate2 {

	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Insert date");
		String stringDate = sc.next();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		
		java.util.Date utilDate = sdf.parse(stringDate);
		System.out.println("util date: "+utilDate);
		
		long ms = utilDate.getTime();
		System.out.println("ms: "+ms);
		
		java.sql.Date sqlDate = new java.sql.Date(ms);
		System.out.println("sqlDate: "+sqlDate);
		
		java.util.Date convertedUtilDate = sqlDate;
		System.out.println("convertedUtilDate "+convertedUtilDate);
		
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
		
		String convertedToString = sdf1.format(convertedUtilDate);
		System.out.println("convertedToString "+convertedToString);
		
		
		
		
	}
}
