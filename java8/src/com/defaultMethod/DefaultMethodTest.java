package com.defaultMethod;

interface Interface1 {

	void method1(String str);

	default void log(String str) {
		System.out.println("I1 logging::" + str);
	}
}

interface Interface2 {

	void method2();

	default void log(String str) {
		System.out.println("I2 logging::" + str);
	}
	
	

}

interface Interface3 {

	void method3();

	default void log(String str) {
		System.out.println("I2 logging::" + str);
	}
	
	

}

class MyClass implements Interface1, Interface2,Interface3 {

	@Override
	public void method1(String str) {
		System.out.println("MyClass method1() implemention of Interface1");
	}

	@Override
	public void method2() {
		System.out.println("MyClass method2() implemention of Interface2");
	}
	
	@Override
	public void method3() {
		System.out.println("MyClass method3() implemention of Interface2");
		
	}
	//@Override
	public void log(String str) {
		System.out.println("xyz");
		//Interface2.super.log(str);
	}

}

public class DefaultMethodTest {

	public static void main(String[] args) {
		MyClass myclass = new MyClass();
		myclass.method1("i1");
		myclass.method2();
		myclass.method3();
		myclass.log("i1");
		
		Interface1 i1 = new MyClass();

	}

}
