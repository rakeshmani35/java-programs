package com.thread.safety;

public class ThreadSafetyWithSynchronizationMutex {


	
	static class ProcessingThread implements Runnable {
		private int count;
		
		//dummy object variable for synchronization
	    private Object mutex=new Object();

		@Override
		public void run() {
			for (int i = 1; i < 5; i++) {
				// processSomething(i);
				synchronized (mutex) {
					System.out.println(Thread.currentThread().getName() + " - " + ++count);
				}

			}
		}

		public int getCount() {
			return this.count;
		}

		private void processSomething(int i) {
			// processing some job
			try {
				Thread.sleep(i * 1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	public static void main(String[] args) throws InterruptedException {

		ProcessingThread pt = new ProcessingThread();

		Thread t1 = new Thread(pt, "t1");
		t1.start();

		Thread t2 = new Thread(pt, "t2");
		t2.start();

		// wait for threads to finish processing
		t1.join();
		t2.join();
		System.out.println("Processing count=" + pt.getCount());
		
		

	}

}
