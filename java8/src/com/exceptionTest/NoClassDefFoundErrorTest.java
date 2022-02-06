package com.exceptionTest;

class ClassWithInitErrors {
	static int data = 1 / 0;
	
}

class NoClassDefFoundErrorExample {
	
	public ClassWithInitErrors getClassWithInitErrors() {
		ClassWithInitErrors test = null;
		try {
			test = new ClassWithInitErrors();
		} catch (Throwable t) {
			System.out.println(t);
		}
		test = new ClassWithInitErrors();
		return test;
	}
}

public class NoClassDefFoundErrorTest {

	public static void main(String[] args) {
		NoClassDefFoundErrorExample sample = new NoClassDefFoundErrorExample();
		sample.getClassWithInitErrors();
	}

}
