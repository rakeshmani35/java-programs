package com.parellal.stream;

import java.util.stream.IntStream;

public class ParellalStream {

	public static void main(String[] args) {

		System.out.println("Normal...");
		IntStream baseStream = IntStream.rangeClosed(1, 10); // created 10 task
		baseStream.forEach(System.out::println);

		System.out.println("Parallel...");
		IntStream parellalStream = IntStream.rangeClosed(1, 10); // created 10 task
		parellalStream.parallel().forEach(System.out::println);
	}

}
