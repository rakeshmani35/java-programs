package com.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

// https://www.baeldung.com/java-lambda-exceptions
public class HandleUnCheckedException {

	public void print() {

		List<Integer> integers = Arrays.asList(3, 9, 7, 6, 10, 20);
		integers.forEach(i -> System.out.print(50 / i + " "));
	}

	// this is not recommended bcz of conciseness of a Lambda Expression is lost
	public void handleUncheckedByTradition() {

		List<Integer> integers = Arrays.asList(3, 9, 7, 0, 10, 20);
		integers.forEach(i -> {
			try {
				System.out.print(50 / i + " ");
			} catch (ArithmeticException e) {
				System.err.println("Arithmetic Exception occured : " + e.getMessage());
			}
		});

	}

	
	public void handleUncheckedByWrapperMethod() { 
		List<Integer> integers = Arrays.asList(3, 9, 7, 0, 10, 20);
		integers.forEach(
		  consumerWrapper(
		    i -> System.out.println(50 / i), 
		    ArithmeticException.class));
	}
	
	public <T, E extends Exception> Consumer<T>
	  consumerWrapper(Consumer<T> consumer, Class<E> clazz) {
	 
	    return i -> {
	        try {
	            consumer.accept(i);
	        } catch (Exception ex) {
	            try {
	                E exCast = clazz.cast(ex);
	                System.err.println(
	                  "Exception occured : " + exCast.getMessage());
	            } catch (ClassCastException ccEx) {
	                throw ex;
	            }
	        }
	    };
	}
	public static void main(String[] args) {

		HandleUnCheckedException exp = new HandleUnCheckedException();

		exp.print();

		System.out.println();
		exp.handleUncheckedByTradition();
		
		System.out.println();
		exp.handleUncheckedByWrapperMethod();
	}

}
