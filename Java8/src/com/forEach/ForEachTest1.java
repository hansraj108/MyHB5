package com.forEach;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class ForEachTest1 {

	
	static Consumer<String> makeUpper = new Consumer<String>() {

		@Override
		public void accept(String t) {
			System.out.println(t.toUpperCase());
			
		}
		
	};
	
	public static void main(String[] args) {
		
		List<String> names = Arrays.asList("Alex", "Brian", "Charles");
		names.forEach(x->System.out.println(x));
		names.forEach(makeUpper);
		
		Map<String, String> map = new HashMap<String, String>();
		 
		map.put("A", "Alex");
		map.put("B", "Brian");
		map.put("C", "Charles");
		
		map.forEach((k,v)->System.out.println(k+" "+v));
		
		List<Integer> numberList = Arrays.asList(1,2,3,4,5);
		
		Consumer<Integer> action = System.out::println;
		
		numberList.stream().filter(n->n%2 ==0).forEach(action);
		
	}
	
	

}
