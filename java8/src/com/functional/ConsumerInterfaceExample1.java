package com.functional;

import java.util.function.Consumer;

/**
 * Consumer<T> It represents an operation that accepts a single argument and
 * returns no result.
 * 
 * @author rakes
 *
 */
public class ConsumerInterfaceExample1 {

	static void printMessage(String name) {
		System.out.println("Hello " + name);
	}

	static void printValue(int val) {
		System.out.println(val);
	}

	public static void main(String[] args) {
	
		// Referring method to String type Consumer interface
		Consumer<String> consume1 = ConsumerInterfaceExample1 :: printMessage;
		consume1.accept("Rakesh");
		
		
		Consumer<Integer> comsumer2 = ConsumerInterfaceExample1 :: printValue;
		comsumer2.accept(12);
	}

}
