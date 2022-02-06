package com.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class StreamFindFirst {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("node", "java", "python", "ruby");

		Stream<String> filter = list.stream();

		Optional<String> findFirst1 = filter.filter(x -> !x.equalsIgnoreCase("java")).findFirst();
		if (findFirst1.isPresent()) {
			System.out.println(findFirst1.get()); // node
		} else {
			System.out.println("no value?");
		}

		Optional<String> findFirst2 = filter.filter(x -> x.equalsIgnoreCase("java")).findFirst();
		if (findFirst2.isPresent()) {
			System.out.println(findFirst2.get()); // node
		} else {
			System.out.println("no value?");
		}
		
	}

}
