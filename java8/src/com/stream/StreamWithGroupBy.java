package com.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamWithGroupBy {

	public static void main(String[] args) {

		List<String> asList = Arrays.asList("apple", "apple", "banana", "apple", "orange", "banana", "papaya");

		// Map<String, List<String>> collect =
		// asList.stream().collect(Collectors.groupingBy(Function.identity()));

		Map<String, Long> collect = asList.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		
		System.out.println(collect);
	}

}
