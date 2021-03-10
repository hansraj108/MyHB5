package com.jwt.util;

public class DateConversion {

	public static java.sql.Date sqlDate(java.util.Date utilDate){
		long ms = utilDate.getDate();
		
		java.sql.Date sqlDate = new java.sql.Date(ms);
		return sqlDate;
	}
	
	public static java.util.Date utilDate(java.sql.Date sqlDate){
	java.util.Date utilDate = sqlDate;
	System.out.println("convertedUtilDate "+utilDate);
	
	return utilDate;
	}
}
