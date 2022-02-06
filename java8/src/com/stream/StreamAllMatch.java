package com.stream;

import java.util.Arrays;
import java.util.List;

public class StreamAllMatch {

	public static void main(String[] args) {

		List<Integer> list1 = Arrays.asList(2, 4, 6, 8, 11);
		boolean b1 = list1.stream().allMatch(i -> i % 2 == 0); // % means remainder 
		System.out.println("all match in list1 = " + b1);  // false

		List<Integer> list2 = Arrays.asList(2, 4, 6, 8, 12);
		boolean b2 = list2.stream().allMatch(i -> i % 2 == 0);
		System.out.println("all match in list2 = " + b2);  // true
	}

}
