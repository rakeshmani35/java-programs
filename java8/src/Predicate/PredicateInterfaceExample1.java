package Predicate;

import java.util.function.Predicate;

/**
 * Predicate<T> It represents a predicate (boolean-valued function) of one
 * argument.
 * 
 * @author rakes
 *
 */
public class PredicateInterfaceExample1 {

	public static void main(String[] args) {

		// Creating predicate
		Predicate<Integer> pr = a -> (a > 18);

		// Calling Predicate method
		boolean bool = pr.test(10);
		System.out.println("bool = " + bool);
	}

}
