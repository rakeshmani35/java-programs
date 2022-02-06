package com.regex;

// https://www.javatpoint.com/java-regex
public class FilterNumber {

	public static void main(String[] args) {

		System.out.println("filter integer from string");

		String str = "rak22roshan44deepak909";

		String[] split = str.split("\\D"); // Any non-digit, short for [^0-9]

		System.out.println("Size of string array = "+split.length);
		
		for (String string : split) {
			System.out.print(string + " ");
		}
	}

}
