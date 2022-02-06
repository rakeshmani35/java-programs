package com.map.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

public class MapValuesTest {

	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap();
		
		map.put(2178, "License extensin date 2178");
		map.put(2065, "License extensin date 2065");
		map.put(2130, "License extensin date 2130");
		
		Collection<String> values = map.values();
       
		int size = values.size();
		String str = "License extensin date";
		List<String> list = new ArrayList<String>();
		String s = "";
		StringJoiner joiner = new StringJoiner(",");
		
		Iterator<String> iterator = values.iterator();
//		while (iterator.hasNext()) {
//			String string = (String) iterator.next();
//			boolean contains = string.contains(str);
//			System.out.println(string);
//			
//			
//			String[] split = string.split(" ");
//			int length = split.length;
//			
//			String string2 = split[length-1];
//			list.add(string2);
//			s += string2+" ";
//			joiner.add(string2);
//		} 
		
		for (String string : map.values()) {
			boolean contains = string.contains(str);
            System.out.println(string);
			String[] split = string.split(" ");
			int length = split.length;
			String string2 = split[length-1];
			list.add(string2);
			s += string2+" ";
			joiner.add(string2);
		}
		
		System.out.println();
	}

}
