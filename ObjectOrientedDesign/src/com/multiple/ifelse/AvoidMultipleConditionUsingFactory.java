package com.multiple.ifelse;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * https://www.baeldung.com/java-replace-if-statements
 * 
 * @author rakes
 *
 */

interface Operation {
	int operation(int a, int b);
}

class Addition implements Operation {
	@Override
	public int operation(int a, int b) {
		return a + b;
	}
}

class Substraction implements Operation {
	@Override
	public int operation(int a, int b) {
		return a - b;
	}
}

class Multiplication implements Operation {
	@Override
	public int operation(int a, int b) {
		return a * b;
	}
}

class Division implements Operation {
	@Override
	public int operation(int a, int b) {
		return a / b;
	}
}

class OperatorFactory {

	static Map<String, Operation> operationMap = new HashMap<String, Operation>();

	static {
		operationMap.put("add", new Addition());
		operationMap.put("substract", new Substraction());
		operationMap.put("multiply", new Multiplication());
		operationMap.put("divide", new Division());
	}

	// factory method
	public static Optional<Operation> getOperation(String operator) {
		Optional<Operation> ofNullable = Optional.ofNullable(operationMap.get(operator));
		return ofNullable;
	}
}

class CalculationUsingFactory {

	public int calculateUsingFactory(int a, int b, String operator) {

		Operation operate = OperatorFactory.getOperation(operator)
				.orElseThrow(() -> new IllegalArgumentException("Invalid Operator"));

		return operate.operation(a, b);
	}
}

public class AvoidMultipleConditionUsingFactory {

	public static void main(String[] args) {

		CalculationUsingFactory calculate = new CalculationUsingFactory();

		int a = 8;
		int b = 2;
		String operator = "add";

		int calculation = calculate.calculateUsingFactory(a, b, operator);

		System.out.println("calculation = " + calculation);
	}

}
