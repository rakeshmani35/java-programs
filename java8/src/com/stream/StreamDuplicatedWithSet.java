package com.stream;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

// https://mkyong.com/java8/java-8-find-duplicate-elements-in-a-stream/
public class StreamDuplicatedWithSet {

	public static void main(String[] args) {

		// 3, 4, 9
		List<Integer> list = Arrays.asList(5, 3, 4, 1, 3, 7, 2, 9, 9, 4);

		Set<Integer> result = findDuplicate(list);
		
		result.forEach(System.out::println);

	}

	private static <T> Set<T> findDuplicate(List<T> list) {
		Set<T> items = new HashSet<>();

		// logic is !items.add(p)
		Set<T> collect = list.stream()
							 .filter(p -> !items.add(p))
							 .collect(Collectors.toSet());

		return collect;

	}

}
