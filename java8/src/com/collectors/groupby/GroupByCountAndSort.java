package com.collectors.groupby;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

// https://mkyong.com/java8/java-8-collectors-groupingby-and-mapping-example/
public class GroupByCountAndSort {

	public static void main(String[] args) {

		List<String> items = Arrays.asList("apple", "apple", "banana", "banana", "banana", "apple", "orange", "banana", "papaya");

		Map<String, Long> collect = items.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		//---------------------------sort by Value in reverse----------------------------------------
		
		// Sort a map and add to sortByValue
		Map<String, Long> mapSortByValue = new LinkedHashMap<>();
		collect.entrySet().stream().sorted(Map.Entry.<String, Long> comparingByValue().reversed())
				                   .forEachOrdered(e -> mapSortByValue.put(e.getKey(), e.getValue()));
		
		System.out.println("sortByValue = "+mapSortByValue);
		
		
		//---------------------------sort by Key in reverse----------------------------------------
		
		// Sort a map and add to sortByKey
		Map<String, Long> mapSortByKey = new LinkedHashMap<>();
		collect.entrySet().stream().sorted(Map.Entry.<String, Long> comparingByKey().reversed())
								   .forEachOrdered(e -> mapSortByKey.put(e.getKey(), e.getValue()));
		
		System.out.println("sortByKey = "+mapSortByKey);
		
	}

}

// {apple=3, banana=2, papaya=1, orange=1}