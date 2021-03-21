package com.nt;

import java.util.HashMap;

public class HashMapIteration {

	public static void main(String[] args) {
		HashMap<Integer, String> myMap = new HashMap<>();
		myMap.put(1, "hans");
		myMap.put(2, "raj");
		myMap.put(3, "tan");
		myMap.put(4, "del");
		myMap.put(5, "tandel");
		
		System.out.println(myMap);
	/*	
		 Iterator<Entry<Integer, String>> itr = myMap.entrySet().iterator();
		 while(itr.hasNext()) {
			 Entry<Integer,String> entry = itr.next();
			 System.out.print(entry.getKey()+" ");
			 System.out.println(entry.getValue());
		 }
	 */
	/*	 Iterator<Integer> kyItr = myMap.keySet().iterator();
		 while(kyItr.hasNext()) {
			 Integer myKey = kyItr.next();
			 System.out.println(myKey+ " " +myMap.get(myKey));
		 }
	*/
	/*
		for(Map.Entry<Integer,String> i:myMap.entrySet()) {
			System.out.print(i.getKey()+" ");
			System.out.println(i.getValue());
	*/
		
	/*	myMap.forEach((key,value)->{
				System.out.print(key+" ");
				System.out.println(value);
		});
	*/
		myMap.entrySet().stream().forEach((entry)->{
			System.out.print(entry.getKey());
			System.out.println(entry.getValue());
			
		});
		
		}
		
	}


