package com.parellal.stream;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PrimeNumberByParallelStream {

	public static boolean isPrime(int n) {
		if (n <= 1) {
			return false;
		}

		boolean anyMatch = IntStream.rangeClosed(2, n / 2).anyMatch(x -> n % x == 0);

		return anyMatch;
	}

	public static void main(String[] args) {

		//.parallel()   with this 23s, without this 1m 10s
		System.out.println("without parallel");
		long startWithoutParallel = System.currentTimeMillis();
		long count = Stream.iterate(0, n -> n + 1)
		      .limit(10000)
		      .filter(PrimeNumberByParallelStream::isPrime)
		      .peek(x -> System.out.format("%s\t", x))
		      .count();
		long endWithoutParallel = System.currentTimeMillis();
		System.out.println("\nTotal: " + count+", time consumed = "+(endWithoutParallel-startWithoutParallel));
		
		
		System.out.println("with parallel");
		long startWithParallel = System.currentTimeMillis();
		long count1 = Stream.iterate(0, n -> n + 1)
		      .limit(10000)
		      .parallel()
		      .filter(PrimeNumberByParallelStream::isPrime)
		      .peek(x -> System.out.format("%s\t", x))
		      .count();
		long endWithParallel = System.currentTimeMillis();
		System.out.println("\nTotal: " + count+", time consumed = "+(endWithParallel-startWithParallel));

	}

}
