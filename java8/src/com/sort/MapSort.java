package com.sort;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

// https://mkyong.com/java8/java-8-how-to-sort-a-map/
// // https://mkyong.com/java8/java-8-collectors-groupingby-and-mapping-example/
public class MapSort {

	public static void main(String[] args) {

		Map<String, Integer> unsortMap = new HashMap<>();
        unsortMap.put("z", 10);
        unsortMap.put("b", 5);
        unsortMap.put("a", 6);
        unsortMap.put("c", 20);
        unsortMap.put("d", 1);
        unsortMap.put("e", 7);
        unsortMap.put("y", 8);
        unsortMap.put("n", 99);
        unsortMap.put("g", 50);
        unsortMap.put("m", 2);
        unsortMap.put("f", 9);
        
        
        // ------------- Approach-1 : sorted by key----------------
        
        // sort by keys, a,b,c..., and return a new LinkedHashMap
        // toMap() will returns HashMap by default, we need LinkedHashMap to keep the order.
       
        LinkedHashMap<String, Integer> sortedMap1 = unsortMap.entrySet().stream().sorted(Map.Entry.comparingByKey())
                                     .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                                    		 					(oldValue, newValue) -> newValue, LinkedHashMap::new));
        
        System.out.println("Approach-1 Sorted Map by key : " + sortedMap1);
        
        
        // ------------- Approach-2 : sorted by key----------------
        
        // Not Recommend, but it works.
        //Alternative way to sort a Map by keys, and put it into the "result" map
        Map<String, Integer> result = new LinkedHashMap<>();
        
        unsortMap.entrySet().stream().sorted(Map.Entry.comparingByKey())
                                     .forEachOrdered(x -> result.put(x.getKey(), x.getValue()));
        
        System.out.println("\nApproach-2 Sorted Map by key : " + result);
        // ------------- sorted by value ---------------
	}

}
