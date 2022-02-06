package com.inheritance;

interface A {
	void m1();
}

interface B {
	void m1();
}


class Test implements A,B{

	@Override
	public void m1() {
		System.out.println("m1() - implemented method");
		
	}
	
}
public class MultipleInheritanceWithInterface {

	public static void main(String[] args) {

		A a = new Test();
		a.m1();
	}

}
