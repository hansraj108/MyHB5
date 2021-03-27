package MyMap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class MyMapTest1 {

	public static void main(String[] args) {
		java8Sorting1();
	}
	
	private static Map<String, Integer> getUnSortedMap() 
    {
        Map<String, Integer> unsortMap = new HashMap<>();
        unsortMap.put("alex", 1);
        unsortMap.put("david", 2);
        unsortMap.put("elle", 3);
        unsortMap.put("charles", 4);
        unsortMap.put("brian", 5);
        return unsortMap;
    }

	
	
	
	private static void java8Sorting1(){
		Map<String, Integer> map = getUnSortedMap();
		LinkedHashMap<String,Integer> sortedMap = new LinkedHashMap<>();
		map.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEachOrdered(x->sortedMap.put(x.getKey(), x.getValue()));
		System.out.println(sortedMap);
		LinkedHashMap<String,Integer> sortedMap1 = new LinkedHashMap<>();
		map.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEachOrdered(x->sortedMap1.put(x.getKey(), x.getValue()));
		System.out.println(sortedMap1);
		LinkedHashMap<String,Integer> sortedMap2 = new LinkedHashMap<>();
		map.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).forEachOrdered(x->sortedMap2.put(x.getKey(), x.getValue()));
		System.out.println(sortedMap2);
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
