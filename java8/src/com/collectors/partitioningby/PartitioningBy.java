package com.collectors.partitioningby;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// https://www.geeksforgeeks.org/collectors-partitioningby-method-in-java/
public class PartitioningBy {

	public static void main(String[] args) {

		// creating an Integer stream
		Stream<Integer> s1 = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

		Map<Boolean, List<Integer>> partitioningBy1 = s1.collect(Collectors.partitioningBy(p -> p > 3));
		
		System.out.println(partitioningBy1);
		// {false=[1, 2, 3], true=[4, 5, 6, 7, 8, 9, 10]}
		
		//----------------------------------------------------------------
		
		Stream<Integer> s2 = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

		Map<Boolean, List<Integer>> partitioningBy2 = s2.collect(Collectors.partitioningBy(p -> p == 3));
		
		System.out.println(partitioningBy2);
		// {false=[1, 2, 4, 5, 6, 7, 8, 9, 10], true=[3]}

	}

}
