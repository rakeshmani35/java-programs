package com.collectors.groupby;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;

// https://mkyong.com/java8/java-8-collectors-groupingby-and-mapping-example/
public class GroupByAndCount {

	public static void main(String[] args) {

		// 3 apple, 2 banana, others 1
		List<String> items = Arrays.asList("apple", "apple", "banana", "apple", "orange", "banana", "papaya");

		Map<String, Long> collect = items.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		System.out.println(collect);
		
		
		System.out.println();
		 Map<String, List<String>> collect2 = items.stream()
			.collect(Collectors.groupingBy(Function.identity()));
		 
		 System.out.println(collect2);

		List<Integer> list = Arrays.asList(3, 4, 5, 6, 5, 4, 4);

		List<Integer> result = new ArrayList<Integer>(); 
		
		/*
		 * list.stream().collect(Collectors.groupingBy(Function.identity(),
		 * Collectors.counting())).entrySet().stream()
		 * .sorted(Map.Entry.comparingByValue()).collect(Collectors.toMap(Map.Entry::
		 * getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue,
		 * LinkedHashMap::new)) .forEach((k, v) -> { for (int i = 0; i < v; i++) {
		 * result.add(k.intValue());
		 * 
		 * } }); System.out.println("Result => "+result); // Result => [3, 6, 5, 5, 4,
		 * 4, 4]
		 */		
		
	
	}

}

// {papaya=1, orange=1, banana=2, apple=3}