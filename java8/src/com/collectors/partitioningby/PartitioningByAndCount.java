package com.collectors.partitioningby;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//https://www.geeksforgeeks.org/collectors-partitioningby-method-in-java/
public class PartitioningByAndCount {

	public static void main(String[] args) {

		// creating an Integer stream
		Stream<Integer> s1 = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

		Map<Boolean, Long> partitioningByAndCount1 = s1
				.collect(Collectors.partitioningBy(p -> p > 3, Collectors.counting()));
		
		System.out.print("partitioning And Count1 : ");
		System.out.println(partitioningByAndCount1);
		// {false=3, true=7}
		
		// ------------------------------------------------------
		
		Stream<Integer> s2 = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		
		Map<Boolean, Long> partitioningByAndCount2 = s2
				.collect(Collectors.partitioningBy(p -> p == 3, Collectors.counting()));
		
		System.out.print("partitioning And Count2 : ");
		System.out.println(partitioningByAndCount2);
		// {false=3, true=7}


	}

}
