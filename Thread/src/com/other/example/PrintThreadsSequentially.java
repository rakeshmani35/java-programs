package com.other.example;
// https://java2blog.com/print-sequence-3-threads-java/

class PrintSequenceRunnable implements Runnable{
 
	public int PRINT_NUMBERS_UPTO=10;
	static int  number=1;
	int remainder;
	static Object lock=new Object();
 
	PrintSequenceRunnable(int remainder)
	{
		this.remainder=remainder;
	}
 
	@Override
	public void run() {
		while (number < PRINT_NUMBERS_UPTO-1) {
			System.out.println("before synchronization thread "+Thread.currentThread().getName());
			synchronized (lock) {
				System.out.println("in synchronization thread "+Thread.currentThread().getName());
				while (number % 3 != remainder) { // wait for numbers other than remainder
					try {
						lock.wait();
						System.out.println("went in wait state  "+Thread.currentThread().getName());
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println(Thread.currentThread().getName() + " " + number);
				number++;
				lock.notifyAll();
				System.out.println("notify by =   "+Thread.currentThread().getName());
			}
		}
	}
}

public class PrintThreadsSequentially {

	public static void main(String[] args) {
		PrintSequenceRunnable runnable1=new PrintSequenceRunnable(1);
		PrintSequenceRunnable runnable2=new PrintSequenceRunnable(2);
		PrintSequenceRunnable runnable3=new PrintSequenceRunnable(0);
		
		Thread t1=new Thread(runnable1,"T1");
		Thread t2=new Thread(runnable2,"T2");
		Thread t3=new Thread(runnable3,"T3");
		
		t1.start();
		t2.start();
		t3.start();

	}

}
