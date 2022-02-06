package com.multiple.ifelse;

/**
 * https://www.baeldung.com/java-replace-if-statements
 * 
 * @author rakes
 *
 */
class CalculationWithMultipleCondition {

	public int calculateUsingIfElse(int a, int b, String operator) {
		int result = Integer.MIN_VALUE;

		if ("add".equals(operator)) {
			result = a + b;
		} else if ("multiply".equals(operator)) {
			result = a * b;
		} else if ("divide".equals(operator)) {
			result = a / b;
		} else if ("subtract".equals(operator)) {
			result = a - b;
		}
		return result;
	}

	public int calculateUsingSwitch(int a, int b, String operator) {

		int result = Integer.MIN_VALUE;

		switch (operator) {
		case "add":
			result = a + b;
			break;
		case "subtract":
			result = a - b;
			break;
		case "multiply":
			result = a * b;
			break;
		case "divide":
			result = a / b;
			break;

		}
		return result;
	}
}

public class MultipleIfElse {

	public static void main(String[] args) {

		CalculationWithMultipleCondition calculator = new CalculationWithMultipleCondition();

		int a = 8;
		int b = 2;
		String operator = "add";

		int calculation = calculator.calculateUsingIfElse(a, b, operator);

		System.out.println("calculation = " + calculation);
	}

}
