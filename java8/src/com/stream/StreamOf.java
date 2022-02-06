package com.stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamOf {

	public static void main(String[] args) {

		Stream<String> stringStream = Stream.of("A", "B", "C", "D");

		Stream<Integer> intStream = Stream.of(1, 2, 3, 4, 5);

		List<String> list1 = stringStream.collect(Collectors.toList());
		List<Integer> list2 = intStream.collect(Collectors.toList());
	}

}
