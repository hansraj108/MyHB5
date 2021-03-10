package com.hr.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.hr.exception.StudentException;

public class StringUtil {
    public static String toCommaSeparatedString(Object[] items){
        StringBuilder sb = new StringBuilder();
        for (Object item : items) {
            sb.append(item).append(",");
        }
        if(sb.length()>0){
            sb.deleteCharAt(sb.length()-1);
        }
        return sb.toString();
    }
    
    
    public static java.sql.Date sqlDate(String date) throws StudentException{
		SimpleDateFormat sdf1=new SimpleDateFormat("dd-MM-yyyy");
	      java.util.Date udob = null;
		try {
			udob = sdf1.parse(date);
		} catch (ParseException e) {
			throw new StudentException("Please insert date in 'DD-MM-YYYY' format");
		}
			java.sql.Date sqdob=new java.sql.Date(udob.getTime());
			return sqdob;
		
			
		}
    
    public static String getStringDOB (java.sql.Date sqdob) {
		java.util.Date udob=sqdob;
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
		return sdf.format(udob);
	}
}
