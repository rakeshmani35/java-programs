package com.string;

import java.util.Map;
import java.util.TreeMap;

// https://stackoverflow.com/questions/35866240/how-to-sort-string-array-by-length-using-arrays-sort
// https://www.techiedelight.com/sort-array-of-strings-java/
// https://www.geeksforgeeks.org/sort-array-strings-according-string-lengths/
// http://www.java2s.com/Tutorials/Java/Stream_How_to/Stream_Sort/Sort_String_Stream_by_length.htm
public class ShortStringByLength {

	public static void print(String str) {
		
		Map<Integer, String> map =  new TreeMap();
		String[] arr = str.split(" ");
		for (String s : arr) {
			
			int key = s.length();
			if (map.containsKey(key)) {
				String value = map.get(key);
				map.put(key, value+" "+s);
			}else {
				map.put(key, s);
			}
		}
		
		map.forEach((key,value) -> System.out.println(value));
	}
	
	public static void main(String[] args) {
		
		String str = "this is kooks are as a book";

		print(str);
	}

}
