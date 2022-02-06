package com.parellal.stream;

import java.util.stream.IntStream;

/**
 * By default, parallel streams use `ForkJoinPool`
 * 
 * @author rakes
 *
 */

public class PrintParallelStreamThread {

	private static IntStream rangeClosed2;

	public static void main(String[] args) {

		System.out.println("Normal...");
		IntStream rangeClosed = IntStream.rangeClosed(1, 10);
		rangeClosed.forEach(x -> System.out.println("Thread : " + Thread.currentThread().getName() + ", value = " + x));

		System.out.println();
		System.out.println("Parallel...");
		rangeClosed2 = IntStream.rangeClosed(1, 10);
		rangeClosed2.parallel()
				.forEach(x -> System.out.println("Thread : " + Thread.currentThread().getName() + ", value = " + x));
	}

}
