package com.memoryLeak;

/**
 * https://www.geeksforgeeks.org/output-of-java-programs-set-10-garbage-collection/
 * 
 * We know that finalize() method is called by Garbage Collector on an object
 * before destroying it. But here, the trick is that the str is String class
 * object, not the Test class. Therefore, finalize() method of String class(if
 * overridden in String class) is called on str. If a class doesn’t override
 * finalize method, then by default Object class finalize() method is called.
 * 
 * @author rakes
 *
 */
public class GCWithString {

	public static void main(String[] args) throws InterruptedException {
		String str = new String("GeeksForGeeks");

		// making str eligible for gc
		str = null;

		// calling garbage collector
		System.gc();

		// waiting for gc to complete
		Thread.sleep(1000);

		System.out.println("end of main");

	}

	// this wont call, bcz of incase of String, string finalize() will call
	@Override
	protected void finalize() throws Throwable {
		System.out.println("finalize method called"); 
	}
}
