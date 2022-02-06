package com.memoryLeak;

/**
 * https://www.geeksforgeeks.org/output-of-java-programs-set-10-garbage-collection/
 * 
 * When Garbage Collector calls finalize() method on an object, it ignores all
 * the exceptions raised in the method and program will terminate normally.
 * 
 * @author rakes
 *
 */
public class GCWithOtherClass {

	public static void main(String[] args) throws InterruptedException {

		GCWithOtherClass t = new GCWithOtherClass();

		// making t eligible for garbage collection
		t = null;

		// calling garbage collector
		System.gc();

		// waiting for gc to complete
		Thread.sleep(1000);

		System.out.println("end main");
	}

	// finalize() ignore exception
	@Override
	protected void finalize() {
		System.out.println("finalize method called");
		System.out.println(10 / 0);
	}
}
