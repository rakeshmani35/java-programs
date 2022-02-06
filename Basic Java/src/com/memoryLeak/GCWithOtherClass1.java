package com.memoryLeak;

public class GCWithOtherClass1 {

	static GCWithOtherClass1 t;

	static int count = 0;

	public static void main(String[] args) throws InterruptedException {

		GCWithOtherClass1 t1 = new GCWithOtherClass1();

		// making t1 eligible for garbage collection
		t1 = null; // line 12

		// calling garbage collector
		System.gc(); // line 15

		// waiting for gc to complete
		Thread.sleep(1000);

		// making t eligible for garbage collection,
		t = null; // line 21

		// calling garbage collector
		System.gc(); // line 24

		// waiting for gc to complete
		Thread.sleep(1000);

		System.out.println("finalize method called " + count + " times");

	}

	@Override
	protected void finalize() {
		count++;

		t = this; // line 38

	}

}
