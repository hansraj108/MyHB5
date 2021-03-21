package MyMap;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class MyMapTest1 {

	public static void main(String[] args) {
		java8Sorting();
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

	private static void java8Sorting(){
	Map<String, Integer> map = getUnSortedMap();
	System.out.println(map);
	LinkedHashMap<String, Integer> sortedMap = new LinkedHashMap<>();
	map.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEachOrdered(x->sortedMap.put(x.getKey(), x.getValue()));
	System.out.println(sortedMap);
	

	}
}
