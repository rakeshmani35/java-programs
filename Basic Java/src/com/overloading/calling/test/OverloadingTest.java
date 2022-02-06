package com.overloading.calling.test;

class Test {

	public void a1(Object obj) {
		System.out.println("Object");
	}

	public void a1(Long obj) {
		System.out.println("Long");
	}

	public void a1(long obj) {
		System.out.println("long");
	}

	/*
	 * public void stringTest(Object obj) { System.out.println("Object"); } public
	 * void stringTest(String obj) { System.out.println("String"); }
	 */
}

public class OverloadingTest {

	public static void main(String[] args) {

		   //Long l = 10; // compilation error
		   Long l1 = 10L;
		   Long l2 = (long) 10;
		   long l3 = 10L;
		   long l4 = 10;

		Test t = new Test();
		t.a1(l1); // Long
		t.a1(l2); // Long
		t.a1(l3); // long
		t.a1(l4); // long

		// t.stringTest("Rakesh");
	}

}
