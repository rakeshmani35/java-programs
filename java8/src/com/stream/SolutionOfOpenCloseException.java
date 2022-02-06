package com.stream;

import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * https://www.baeldung.com/java-stream-operated-upon-or-closed-exception
 * 
 * The solution is consists of creating a new Stream each time we need one. We
 * can, of course, do that manually, but that's where the Supplier functional
 * interface becomes really handy:
 * 
 * @author rakes
 *
 */
public class SolutionOfOpenCloseException {

	public static void main(String[] args) {

		String[] array = { "a", "b", "c", "d", "e" };

		Supplier<Stream<String>> supplier = () -> Stream.of(array);

		// get new stream
		// supplier.get().forEach(System.out::print);
		supplier.get().forEach((x) -> System.out.print(x + " "));

		
		System.out.println();
		
		// get another new stream
		long count = supplier.get().filter((x) -> x.equals("b")).count();
		System.out.println("count : " + count);
	}

}