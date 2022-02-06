package com.override;

interface A {
	
	public void m1();
}

class B implements A {

	@Override
	public void m1() {
		System.out.println("m1() - A");
	}
	
	
	public void m2() {
		System.out.println("m2() - A");
	}
	
}

public class OverridingTest1 {
	
	public static void main(String[] args) {

		A a1 = new B();
		a1.m1(); // m1() - A
		//a1.m2(); // compiletime error: The method m2() is undefined for the type A
		
		B b = new B();
		b.m1(); // m1() - A
		b.m2(); // m2() - A
	}

}
