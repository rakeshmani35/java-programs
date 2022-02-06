package com.multiple.ifelse;

/**
 * https://www.baeldung.com/java-replace-if-statements
 * 
 * @author rakes
 *
 */
enum Operator {

	ADD {
		@Override
		public int calculate(int a, int b) {
			return a + b;
		}
	},
	SUBTRACT {
		@Override
		public int calculate(int a, int b) {
			return a - b;
		}
	},
	MULTIPLY {
		@Override
		public int calculate(int a, int b) {
			return a * b;
		}
	},
	DIVIDE {
		@Override
		public int calculate(int a, int b) {
			return a / b;
		}
	};

	public abstract int calculate(int a, int b);

}

class CalculateUsingEnum {

	public int calculate(int a, int b, Operator operator) {

		return operator.calculate(a, b);
	}
}

public class AvoidMultipleConditionUsingEnum {

	public static void main(String[] args) {

		CalculateUsingEnum calculate = new CalculateUsingEnum();
		
		int a = 8;
		int b = 2;
		Operator operator = Operator.valueOf("ADD");
		
		int calculation = calculate.calculate(a, b, operator);
		
		System.out.println("calculation = " + calculation);
	}

}
