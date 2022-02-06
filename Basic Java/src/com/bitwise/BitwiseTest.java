package com.bitwise;

// https://www.geeksforgeeks.org/bitwise-operators-in-java/
public class BitwiseTest {

	public static void main(String[] args) {

		// Initial values
		int a = 5; // 0101
		int b = 7; // 0111

		// bitwise and
		// 0101 & 0111=0101 = 5(0101)
		System.out.println("a&b = " + (a & b)); // 5

		// bitwise or
		// 0101 | 0111 = 7(0111)
		System.out.println("a|b = " + (a | b)); // 7

		// bitwise xor, if corresponding bits are different, it gives 1,else it gives 0.
		// 0101 ^ 0111=2(0010)
		System.out.println("a^b = " + (a ^ b)); // 2

		// bitwise complement
		// ~0101=10(1010)
		// will give 2's complement of 1010 = (1011)-6
		System.out.println("~a = " + ~a);
	}

}
