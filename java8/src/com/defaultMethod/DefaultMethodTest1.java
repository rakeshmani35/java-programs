package com.defaultMethod;

interface Interf1 {

	void method1(String str);

	default void log1(String str) {
		System.out.println("I1 logging::" + str);
	}
}

interface Interf2 {

	void method2();

	default void log2(String str) {
		System.out.println("I2 logging::" + str);
	}

}

interface Interf3 {

	void method3();

	default void log3(String str) {
		System.out.println("I3 logging::" + str);
	}

}

interface Interf4 {

	void method4();

	default void log3(String str) {
		System.out.println("I3 logging::" + str);
	}

}

class MyClass1 implements Interf1, Interf2, Interf3, Interf4 {

	@Override
	public void method1(String str) {
		System.out.println("MyClass method1() implemention of Interface1");
	}

	@Override
	public void method3() {
		System.out.println("MyClass method3() implemention of Interface3");

	}

	@Override
	public void method2() {
		System.out.println("MyClass method3() implemention of Interface3");

	}
	
	@Override
	public void method4() {
		System.out.println("MyClass method4() implemention of Interface4");
	}

	@Override
	public void log3(String str) {
		// TODO Auto-generated method stub
		Interf4.super.log3(str);
	}

}

public class DefaultMethodTest1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
