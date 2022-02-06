package java8com.method.reference;

import java.util.function.BiFunction;

class Arithmetic {
	public static int add(int a, int b) {
		return a + b;
	}

	public static float add(int a, float b) {
		return a + b;
	}

	public static float add(float a, float b) {
		return a + b;
	}
}

public class MethodReference4 {

	public static void main(String[] args) {
		
		BiFunction<Integer, Integer, Integer> adder1 = Arithmetic :: add;
		
		BiFunction<Integer, Float, Float> adder2 = Arithmetic :: add;
		
		 BiFunction<Float, Float, Float> adder3 = Arithmetic :: add;
		 
		 Integer result1 = adder1.apply(3, 5);
		 
		 Float result2 = adder2.apply(3, 5.0f);
		 
		 Float result3 = adder3.apply(3.0f, 5.0f);
		 
		 System.out.println("result1 = "+result1);  
		 System.out.println("result2 = "+result2);  
		 System.out.println("result3 = "+result3); 

	}

}
