package com.shif.operator;

// https://codescracker.com/java/java-left-shift.htm
public class LeftShiftOperator {

	public static void main(String[] args) {

		byte a = 64, b;
		int i;

		i = a << 1;
		b = (byte) (a << 1);

		System.out.println("Original value of a : " + a);
		System.out.println("i is " + i + " and b is " + b);
		
		System.out.println();
		
		i = a << 2;
        b = (byte) (a << 2);
        
        System.out.println("Original value of a : " +a);
        System.out.println("i is " + i + " and b is " + b);
        
        System.out.println();
        
        char c = 'a';
        int x = c<<1;
        System.out.println("Original value of x : " +x);
        
        String str = "a";
        //int y = str<<1; // The operator << is undefined for the argument type(s) String, int

        
	}

}
