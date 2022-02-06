package com.stream;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class FrequencyTest {

	public static void frequency(String str) {
		
		Set<String> set = new HashSet<>();
		
		String[] arr = str.split(" ");
		
		for (String s : arr) {
			String value = "";
			int frequency = Collections.frequency(Arrays.asList(arr), s);

			value = s+" = "+ frequency;
			set.add(value);
			
		}
		System.out.println(set);
	}
	
	public static void main(String[] args) {
		
      String str = "This is a book is this this book is is";
      
      frequency(str);
	}

}
