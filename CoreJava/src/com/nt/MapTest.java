package com.nt;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MapTest {

	public static void main(String[] args) {
		
		Map<String, String> m = new HashMap<>();
		m.put("hans", "raj");
		m.put("tandel", "raj");
		m.put("121", "1451");
		
		System.out.println(m);
		Set<String> keys = m.keySet();
		
		for(String key : keys) {
			System.out.println(m.get(key));
		}
		
		Set<Entry<String, String>> entrySets = m.entrySet();
		for(Map.Entry<String, String> entryset : entrySets) {
			System.out.println(entryset.getKey()+ "..."+entryset.getValue());
			
		}
	}
}
