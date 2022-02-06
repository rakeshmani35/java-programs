package com.string;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class SortMapByValue {

	public static void sortByValue(Map map) {

		// 1. Convert Map to List of Map for sort
		List<Map.Entry<Integer, String>> list = new LinkedList(map.entrySet());

		// 2. Sort list with Collections.sort(), provide a custom Comparator
		// Try switch the o1 o2 position for a different order
		Collections.sort(list, new Comparator<Map.Entry<Integer, String>>() {
			@Override
			public int compare(Map.Entry<Integer, String> o1, Map.Entry<Integer, String> o2) {
				Integer obj1 = new Integer(o1.getValue().length());
				Integer obj2 =  new Integer(o2.getValue().length());
				return obj1.compareTo(obj2);
			}
		});
		
		
		// Java8
		Collections.sort(list,  (Comparator<Map.Entry<Integer, String>>) 
				(o1, o2) -> {
		
		Integer obj1 = new Integer(o1.getValue().length());
		Integer obj2 =  new Integer(o2.getValue().length());
		return obj1.compareTo(obj2);
				}
		);

		// 3. Loop the sorted list and put it into a new insertion order Map LinkedHashMap
		Map<Integer, String> sortedMap = new LinkedHashMap<Integer, String>();
		for (Entry<Integer, String> entry : list) {
			sortedMap.put(entry.getKey(), entry.getValue());
		}
		
		sortedMap.forEach((key,value)->System.out.println(key + " : " + value));
	}

	public static void main(String[] args) {

		Map<Integer, String> map = new HashMap<Integer, String>();

		map.put(1, "this");
		map.put(2, "are");
		map.put(3, "is");
		map.put(4, "a");
		map.put(5, "kooks");
		map.put(6, "book");

		sortByValue(map);
	}

}

/**
 * putput:
4 : a
3 : is
2 : are
1 : this
6 : book
5 : kooks

*/
