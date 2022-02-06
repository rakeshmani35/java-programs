package com.statictest;

class SampleClass {
	static class Test {
		int num = 300;

		public Test() {

		}

		public Test(String str) {

		}

		public void display() {
			System.out.println("static inner class");
		}
	}

	class DemoClass extends Test {
		public void display() {
			System.out.println("Instance Ineer class");
		}
	}

}

public class StaticClassExample {

	public static void main(String[] args) {

		// create instance of nested Static class
		SampleClass.Test innerStatic = new SampleClass.Test();
		
		innerStatic.display();
		
		SampleClass.Test innerInstanceClass = new SampleClass().new DemoClass();
		
		innerInstanceClass.display();
		
		
	}

}
