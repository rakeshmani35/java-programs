package com.oops;

interface Shape {
	void draw();
}

class Rectangle implements Shape {
	public void draw() {
		System.out.println("drawing rectangle...");
	}
}

class Circle implements Shape {
	public void draw() {
		System.out.println("drawing circle...");
	}
}

class Triangle implements Shape {
	public void draw() {
		System.out.println("drawing triangle...");
	}
}

public class RuntimePolymorphism {

	public static void poly(Shape s) {
		s.draw();
	}
	
	public static void main(String[] args) {
		poly(new Circle());

	}

}
