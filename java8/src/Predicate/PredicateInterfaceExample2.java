package Predicate;

import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Predicate<T> It represents a predicate (boolean-valued function) of one
 * argument.
 * 
 * @author rakes
 *
 */
class PredicateInterfaceExample {
	static Boolean checkAge(int age) {
		if (age > 17)
			return true;
		else
			return false;
	}
}

public class PredicateInterfaceExample2 {

	public static void main(String[] args) {

		// using Function functional-interface
		Function<Integer, Boolean> fun = PredicateInterfaceExample::checkAge;
		boolean bool = fun.apply(10);
		System.out.println("bool = " + bool);

		// Using Predicate functional-interface
		Predicate<Integer> pr = PredicateInterfaceExample::checkAge;
		boolean result = pr.test(25);
		System.out.println("result = " + result);
	}

}
