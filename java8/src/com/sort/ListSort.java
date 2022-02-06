package com.sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

// https://mkyong.com/java8/java-8-how-to-sort-list-with-stream-sorted/
public class ListSort {

	public static void main(String[] args) {
		
		List<String> list = Arrays.asList("9", "A", "Z", "1", "B", "Y", "4", "a", "c");
		
		// -------------- Sort List in Natural Order -----------------
		
		List<String> sortedList = list.stream().sorted().collect(Collectors.toList());
		
		System.out.println("sorted list in natural order : ");
		sortedList.forEach(p -> System.out.print(p+" "));  
		
		
		// -------------- Sort List in Reverse Order --------------------
		
		List<String> sortedList2 = list.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
		
		System.out.println("\n\nsorted list in reverse order : ");
		sortedList2.forEach(p -> System.out.print(p+" "));

	}

}
