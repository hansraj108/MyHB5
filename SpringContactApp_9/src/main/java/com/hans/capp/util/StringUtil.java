package com.hans.capp.util;

public class StringUtil {

	public static String toCommaSeperatedString(Object[] items) {
		StringBuilder sb = new StringBuilder();
		for(Object ob : items) {
			sb.append(ob).append(",");
		}
		if(sb.length()>0) {
			sb.deleteCharAt(sb.length()-1);
		}
		return sb.toString();
	}
}
