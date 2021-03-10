package com.nt;

public class ToCommaString {

	public static void main(String[] args) {
		
		String[] ids = {"10","20","30","40","50"};
		
		String s = toComma(ids);
		System.out.println(s);

	}
	
	public static String toComma(String[] ids) {
		
		StringBuilder sb = new StringBuilder();
		for(Object obj : ids) {
		sb.append(obj).append(",");
		}
		if(sb.length()>0) {
			sb.deleteCharAt(sb.length()-1);
		}
		return sb.toString();
	}

}
