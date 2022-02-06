package com.oracle;

class Parent {
	String x = "parent instance variable";

	public void parentMethod() {
		System.out.println("parentMethod instance method");
	}
}

class Child extends Parent {
	String x = "child instance variable";

	public void childMethod() {
		System.out.println("childMethod instance method");
		this.parentMethod();
		super.parentMethod();
		System.out.println("child method this.x = "+this.x);
	}
}

public class InheritanceTest {

	public static void main(String[] args) {

		String x = "Main instance variable";

		// test 1
		Parent p = new Child();
		System.out.println("p.x = "+p.x);
		p.parentMethod();
		
		// test 2
		System.out.println("--------------");
		Child c = new Child();
		System.out.println("c.x = "+c.x);
		c.parentMethod();
		c.childMethod();
	}

}
