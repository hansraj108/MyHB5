package com.nt;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class CollectionTest {

	public static void main(String[] args) {
		
//array testing 1
	String[] arry = new String[4];
	arry[0] = "hans";
	//	arry[1] = 12;
	for(int i=0; i<arry.length;i++) {
	System.out.println(arry[i]);
	}
	System.out.println("array testing 1 ===============>");

	//array testing 2
	String[] arry1 = {"hans","raj","tan","del"};
	
	for(String s : arry1) { 
		System.out.println(s);
	}
	System.out.println("array testing 2 ===============>");
	
	//array testing 3
	Object[] obj = new Object[4];
	obj[0] = "hans";
	obj[1] = 8;
	obj[1] = null;
	obj[1] = 9;
	
	for(Object o : obj) { 
		System.out.println(o);
	}
	System.out.println("array testing 3 ===============>");
	
	//collection
	
	//collection testing 1 --> iterator
	System.out.println("collection testing 1 ===============>");
	Collection coll = new ArrayList();
	coll.add("hans");
	coll.add(7);
	coll.add(null);
	
	Iterator itr = coll.iterator();
	while(itr.hasNext()) {
		System.out.println(itr.next());
	}
	
	//collection testing 2 --> for loop  --> we cant sort the collections
		System.out.println("collection testing 2 ===============>");
		Collection coll1 = new ArrayList();
		coll1.add("hans");
		coll1.add(7);
		coll1.add(8);
		coll1.add(9);
		coll1.add(10);
		coll1.add(11);
	//	Collections.sort(coll1);    		--> we can not sort the collection
		
		for (Object obj1 : coll1) {
			System.out.println(obj1);
		}
		
		//collection testing 3 to insert at certain position use add( , ) two argument method of List interface
		//																						----------------
				System.out.println("collection testing 3 ===============>");
				List coll2 = new ArrayList();
				coll2.add("hans");
				coll2.add(7);
				coll2.add(null);
				coll2.add(2,"ggg");
				coll2.add(9);
				coll2.add(10);
				coll2.add(8);
				coll2.add(12);
				coll2.add(11);
//				Collections.sort(coll2);    --> here we get error  java.lang.ClassCastException: java.lang.String cannot be cast to java.lang.Integer
				for (Object obj1 : coll2) {
					System.out.println(obj1);
				}
				
				//collection <generics> testing 4 to sorting list
				//																						----------------
						System.out.println("collection testing 4 ===============>");
						List<Integer> coll3 = new ArrayList<Integer>(10);
						System.out.println("Size : "+coll3.size());
					//	coll3.add("hans");
						coll3.add(7);
					//	coll3.add(null);
					//	coll3.add(2,"ggg");
						coll3.add(9);
						coll3.add(10);
						coll3.add(8);
						coll3.add(12);
						coll3.add(11);
						
						 Collections.sort(coll3);    
						coll3.forEach(System.out::println);   //stream api uses lambda expression
						System.out.println("Size : "+coll3.size());
						
						
		//Vector	-> dynamic arry -> synchronized -> ThreadSafe -> slow
					System.out.println("collection testing 4 ===============>");		
					Vector v = new Vector();
					System.out.println("Capacity: "+v.capacity());	// default capacity 10
					v.addElement("hans");
					v.add("tan");
					v.add("del");
					v.remove("tan");
					v.forEach(System.out::println);
					System.out.println("Capacity: "+v.capacity());
}
	
}