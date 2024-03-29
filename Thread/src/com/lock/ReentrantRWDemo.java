package com.lock;

import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class ReadThreadClass implements Runnable {

	ReentrantRWDemo rwDemo;

	ReadThreadClass(ReentrantRWDemo rwDemo) {
		this.rwDemo = rwDemo;
	}

	@Override
	public void run() {
		System.out.println("reading - " + rwDemo.readResource("1") + " : " + Thread.currentThread().getName());
	}

}

class WriterThreadClass implements Runnable {

	ReentrantRWDemo rwDemo;

	WriterThreadClass(ReentrantRWDemo rwDemo) {
		this.rwDemo = rwDemo;
	}

	@Override
	public void run() {
		System.out
				.println("writting - " + rwDemo.writeResource("4", "Four") + " : " + Thread.currentThread().getName());
		// rwDemo.writeResource("4", "Four");
	}

}

public class ReentrantRWDemo {

	private final Map<String, String> map = new TreeMap<String, String>();
	private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
	private final ReentrantReadWriteLock.ReadLock readLock = lock.readLock();
	private final ReentrantReadWriteLock.WriteLock writeLock = lock.writeLock();

	public String readResource(String key) {
		System.out.println("readResource - waiting to acquire lock : " + Thread.currentThread().getName());
		readLock.lock();
		System.out.println("readResource - acquired read lock : " + Thread.currentThread().getName());
		try {
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return map.get(key);
		} finally {
			readLock.unlock();
			System.out.println("readResource - released read lock : " + Thread.currentThread().getName());
		}
	}

	public String writeResource(String key, String value) {
		System.out.println("writeResource - waiting to acquire lock : " + Thread.currentThread().getName());
		writeLock.lock();
		System.out.println("writeResource - acquired write lock : " + Thread.currentThread().getName());
		try {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return map.put(key, value);
		} finally {
			writeLock.unlock();
			System.out.println("writeResource - released write lock : " + Thread.currentThread().getName());
		}
	}

	public void display() {
		//System.out.print("display : ");
		map.entrySet().forEach(System.out::println);

	}

	public static void main(String[] args) {

		ReentrantRWDemo rwDemo = new ReentrantRWDemo();

		rwDemo.writeResource("1", "One");
		rwDemo.writeResource("2", "Two");
		rwDemo.writeResource("3", "Three");

		// Starting two read threads and one write thread
		Thread rThread1 = new Thread(new ReadThreadClass(rwDemo));
		Thread wThread = new Thread(new WriterThreadClass(rwDemo));
		Thread rThread2 = new Thread(new ReadThreadClass(rwDemo));
		rThread1.start();
		wThread.start();
		rThread2.start();

		rwDemo.display();
	}

}
