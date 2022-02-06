package com.enm;

/**
 * https://www.programiz.com/java-programming/enum-inheritance
 * 
 * enum classes can implement interfaces.
 * 
 * @author rakes
 *
 */
interface Pizza {
	public void displaySize();
}

enum Size1 implements Pizza {
	SMALL, MEDIUM, LARGE, EXTRALARGE;

	//private final int pizzaSize;
	
	private Size1() {
	      //this.pizzaSize = pizzaSize;
	   }
	
	public void displaySize() {
		System.out.println("The size is " + this);
	}
}

public class EnumCanImplementInterface {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
