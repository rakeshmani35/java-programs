package com.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

// https://mkyong.com/java8/java-8-find-duplicate-elements-in-a-stream/
public class StreamDuplicatedWithGroupBy {

	public static void main(String[] args) {

		// 3, 4, 9
		List<Integer> list = Arrays.asList(5, 3, 4, 1, 3, 7, 2, 9, 9, 4);

		Set<Integer> result = findDuplicateByGrouping(list);

		result.forEach(System.out::println);
	}

	public static <T> Set<T> findDuplicateByGrouping(List<T> list) {

		Set<T> collect = list.stream()
				             .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
				             .entrySet().stream()
				             .filter(p -> p.getValue() > 1)
				             .map(Map.Entry::getKey)
				             .collect(Collectors.toSet());

		return collect;
	}
}
