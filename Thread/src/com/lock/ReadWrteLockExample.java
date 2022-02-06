package com.lock;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class ReadThread implements Runnable {

	private Lock lock;

	public ReadThread(Lock lock) {
		this.lock = lock;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

}

public class ReadWrteLockExample {

	private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
	private final Lock writeLock = readWriteLock.writeLock();
	private final Lock readLock = readWriteLock.readLock();
	private final List<String> list = new ArrayList<>();

	private String readResource(int i) {
		// acquire the thread for reading
		readLock.lock();
		try {
			System.out.println("Elements by thread " + Thread.currentThread().getName() + " is printed");
			return list.get(i);
		} finally {
			// To unlock the acquired read thread
			readLock.unlock();
		}
	}

	private void writeResource(String s) {

		// acquire the thread for writing
		writeLock.lock();
		try {
			list.add(s);
			System.out.println("Element by thread " + Thread.currentThread().getName() + " is added");
		} finally {
			// To unlock the acquired write thread
			writeLock.unlock();
		}

	}

	public static void main(String[] args) {

		ReadWrteLockExample obj = new ReadWrteLockExample();
		obj.writeResource("hi");
		obj.writeResource("hey");
		obj.writeResource("hello");

		System.out.println("Printing the last element : " + obj.readResource(2));
	}

}
