package com.lock;

import java.util.Date;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// https://howtodoinjava.com/java/multi-threading/how-to-use-locks-in-java-java-util-concurrent-locks-lock-tutorial-and-example/
class PrintingJob implements Runnable {

	private PrinterQueue printerQueue;

	public PrintingJob(PrinterQueue printerQueue) {
		this.printerQueue = printerQueue;
	}

	@Override
	public void run() {

		System.out.printf("%s: Going to print a document\n", Thread.currentThread().getName());
		printerQueue.printJob(new Object());

	}

}

class PrinterQueue {

	private final Lock queueLock = new ReentrantLock();

	public void printJob(Object documnet) {
		queueLock.lock();

		try {
			Long duration = (long) (Math.random() * 1000);
			System.out.println(Thread.currentThread().getName() + ": PrintQueue: Printing a Job during "
					+ (duration / 1000) + " seconds :: Time - " + new Date());

			Thread.sleep(duration);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			System.out.printf("%s: The document has been printed\n", Thread.currentThread().getName());
			queueLock.unlock();
		}

	}
}

public class PrintingJobExample {

	public static void main(String[] args) {

		PrinterQueue printerQueue = new PrinterQueue();
		Thread thread[] = new Thread[5];
		for (int i = 0; i < 5; i++) {
			thread[i] = new Thread(new PrintingJob(printerQueue), "Thread " + i);
		}
		for (int i = 0; i < 5; i++) {
			thread[i].start();
		}
	}

}
