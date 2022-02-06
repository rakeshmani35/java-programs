package java8com.method.reference;

import java.util.function.BiFunction;

class Arithmethic {
	
	public static int add(int a, int b) {
		return a+b;
	}
}

public class MethodReference3 {

	public static void main(String[] args) {

		BiFunction<Integer, Integer, Integer> adder = Arithmethic :: add;
		int result = adder.apply(3, 5);
		System.out.println("result = "+result);
	}

}
